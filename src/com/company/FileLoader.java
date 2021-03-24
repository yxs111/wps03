package com.company;

//@1
//以特定编码格式读取文件到xx??
//FileInputStream fis = new FileInputStream(f);
//BufferedReader in = new BufferedReader(new InputStreamReader(fis, charset));
//@2
//已发现如果存在DocumentListener或者UndoableEditListener
//在Document内监听的话,此时读取文件到Document将被阻塞,故先移除,等
//操作结束后再加回来

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

//@version 1.0

class FileLoader implements Runnable {

    Thread t;
    Document doc;
    DocumentListener documentListener;
    UndoableEditListener undoableEditListener;
    final File f;
    Charset charset;

    public FileLoader(Document doc, DocumentListener listener1, UndoableEditListener listener2, File f, Charset charset) {
        this.doc = doc;
        this.documentListener = listener1;
        this.undoableEditListener = listener2;
        this.f = f;
        this.charset = charset;
        if (this.charset == null || !Charset.isSupported(this.charset.name())) {
            this.charset = Charset.defaultCharset();
        }
    }

    public void start() {
        try {
            t = new Thread(this);
            t.setPriority(7);
            t.start();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void run() {
        synchronized (f) {

            FileInputStream fis = null;
            BufferedReader in = null;
            try {
                fis = new FileInputStream(f);
                in = new BufferedReader(new InputStreamReader(fis, charset));//以特定编码格式读取文件
                char[] buff = new char[4096];
                int nch;
                doc.removeDocumentListener(documentListener);
                doc.removeUndoableEditListener(undoableEditListener);
                //已发现如果存在DocumentListener或者UndoableEditListener
                //在doc内监听的话,此时读取文件到doc将被阻塞,故先移除,等
                //操作结束后再加回来
                while ((nch = in.read(buff, 0, buff.length)) != -1) {
                    doc.insertString(doc.getLength(), new String(buff, 0, nch), null);

                }
            } catch (BadLocationException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
                in = null;
                fis = null;
            } finally {
                try {
                    in.close();
                    fis.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                doc.addDocumentListener(documentListener);
                doc.addUndoableEditListener(undoableEditListener);
            }
        }
    }

    public void stop() {
        try {
            t.interrupt();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            t = null;
        }
    }
}

class FileSaver implements Runnable {

    Thread t;
    Document doc;
    final File f;
    Charset charset;

    public FileSaver(Document doc, File f, Charset charset) {
        this.doc = doc;
        this.f = f;
        this.charset = charset;
        if (this.charset == null || !Charset.isSupported(this.charset.name())) {
            this.charset = Charset.defaultCharset();
        }
    }

    public void start() {
        try {
            t = new Thread(this);
            t.setPriority(4);
            t.start();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void run() {
        synchronized (f) {
            FileOutputStream fos = null;
            BufferedWriter out = null;
            try {
                fos = new FileOutputStream(f);
                out = new BufferedWriter(new OutputStreamWriter(fos, charset));//以特定编码格式写入文件
                Segment text = new Segment();
                text.setPartialReturn(true);
                int length = doc.getLength();
                int charsLeft = length;
                int offset = 0;
                while (charsLeft > 0) {
                    doc.getText(offset, Math.min(4096, charsLeft), text);
                    out.write(text.array, text.offset, text.count);
                    charsLeft -= text.count;
                    offset += text.count;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (BadLocationException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
                fos = null;
                out = null;
            } finally {
                try {
                    out.flush();
                    out.close();
                    fos.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        try {
            t.interrupt();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            t = null;
        }
    }
}
