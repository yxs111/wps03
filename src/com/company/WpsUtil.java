package com.company;

import com.wps.api.tree.wps.Application;
import com.wps.api.tree.wps.WdHeaderFooterIndex;
import com.wps.api.tree.wps.WdPageNumberStyle;

import java.math.BigDecimal;

import static com.wps.api.tree.wps.WdHeaderFooterIndex.wdHeaderFooterPrimary;
import static com.wps.api.tree.wps.WdInformation.wdNumberOfPagesInDocument;


public class WpsUtil {


    // 页眉和页脚相关判断
    public BigDecimal headerFootStyle(Application app){
        BigDecimal headerFoot = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("25.0000");
        BigDecimal subjectError = new BigDecimal("0.00000");
        // 获取页眉内容
        String headerText = app.get_ActiveDocument().get_Sections().Item(1).get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Text().trim();

        // 获取页脚的页码样式
        // boolean footNumberExists = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(wdHeaderFooterPrimary).get_PageNumbers().get_RestartNumberingAtSection();
        WdPageNumberStyle footNumberStyle = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(wdHeaderFooterPrimary).get_PageNumbers().get_NumberStyle();

        // 页眉
        if (headerText.equals("WPS办公应用职业技能等级标准")){
            // 页眉内容 字体大小 字体样式 对齐方式为居中
            String headerTextFontStyleName = app.get_ActiveDocument().get_Sections().Item(1).get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Font().get_Name();
            float headerTextFontSize = app.get_ActiveDocument().get_Sections().Item(1).get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Font().get_Size();
            String headerAlignmentName =  app.get_ActiveDocument().get_Sections().Item(1).get_Headers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_ParagraphFormat().get_Alignment().name();
            if(headerTextFontStyleName.equals("宋体") && headerTextFontSize == 12.0 && headerAlignmentName.equals("wdAlignParagraphCenter")){
                headerFoot = headerFoot.add(countNum);
            }else {
                headerFoot = headerFoot.add(subjectError);
            }
        }
        if(headerText != "WPS办公应用职业技能等级标准"){
            headerFoot = headerFoot.add(subjectError);
        }

        // 页脚
        if(footNumberStyle.toString().equals("wdPageNumberStyleArabic")){
            headerFoot = headerFoot.add(countNum);
        }

        return headerFoot.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    // 标题1字体大小为 22.0 黑体
    // 标题2字体大小为 16.0 黑体
    // 标题3字体大小为 16.0 宋体
    // 正文使用12号宋体，西文及数字使用12号Times New Roman字体 1.5倍行距
    // 标题和正文相关判断
    public BigDecimal titleContentTextStyle(Application app){
        BigDecimal titleContent = new BigDecimal("0.00000");
        BigDecimal countNum = new BigDecimal("0.5814");
        BigDecimal subjectError = new BigDecimal("0.00000");

        // 文档中是否存在目录
        try {
            int  heading = app.get_ActiveDocument().get_TablesOfContents().Item(1).get_UpperHeadingLevel();
            if(heading == 1){
                // 存在目录
                String  headingFontName = app.get_ActiveDocument().get_TablesOfContents().Item(1).get_Range().get_Font().get_Name();
                float headingFontSize = app.get_ActiveDocument().get_TablesOfContents().Item(1).get_Range().get_Font().get_Size();
                if(headingFontName.equals("宋体") && headingFontSize == 12.0){
                    titleContent = titleContent.add(countNum);
                }
            }
            if (heading != 1){
                // 不存在目录
                titleContent = titleContent.add(subjectError);
            }
        }catch (Exception e){
            titleContent = titleContent.add(subjectError);
        }

        // 文档中有多少段落（获取值比实际段落值多一）
        int outLineCount = app.get_ActiveDocument().get_Content().get_Paragraphs().get_Count();
        for (int i = 0 ; i < outLineCount ;i++){
            // 判断当前段落是否需要设置为标题
            if (i == 1 || i == 4 || i == 6 ||
                    i == 8 || i == 10 || i == 12 ||
                    i == 14 || i == 16 || i == 18 ||
                    i == 20 || i == 22 || i == 24 ||
                    i == 25 || i == 27 || i == 29 ||
                    i == 32 || i == 34 || i == 35 ||
                    i == 37 || i == 39 || i == 41){
                // 文本规定为标题
                String titleStyleName = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_OutlineLevel().name();
                if (titleStyleName.equals("wdOutlineLevel1")){
                    // 文本为标题1 并获取字体样式和大小
                    Float fontSize = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Size();
                    String fontName = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Name();

                    if(fontSize == 22.0 && fontName.equals("黑体")){
                        titleContent = titleContent.add(countNum);
                    }else{

                        titleContent = titleContent.add(subjectError);
                    }
                }else if (titleStyleName.equals("wdOutlineLevel2")){
                    // 文本为标题2 并获取字体样式和大小
                    Float fontSize = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Size();
                    String fontName = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Name();
                    if(fontSize == 16.0 && fontName.equals("黑体")){
                        titleContent = titleContent.add(countNum);
                    }else{

                        titleContent = titleContent.add(subjectError);
                    }
                }else if (titleStyleName.equals("wdOutlineLevel3")){
                    // 文本为标题3 并获取字体样式和大小
                    Float fontSize = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Size();
                    String fontName = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Name();
                    int bold = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Bold();
                    System.out.println(bold);
                    if(fontSize == 16.0 && fontName.equals("宋体")){
                        titleContent = titleContent.add(countNum);
                    }else{

                        titleContent = titleContent.add(subjectError);
                    }
                }else{

                    titleContent = titleContent.add(subjectError);
                }
            }
            if(i == 2 || i == 3 || i == 5 ||
                    i == 7 || i == 9 || i == 11 ||
                    i == 13 || i == 15 || i == 17 ||
                    i == 19 || i == 21 || i == 23 ||
                    i == 26 || i == 28 || i == 30 ||
                    i == 31 || i == 33 || i == 36 ||
                    i == 38 || i == 40 || i == 42){
                // 文本不为标题
                String countText = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Text();
                Float fontSize = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Size();
                String fontName = app.get_ActiveDocument().get_Content().get_Paragraphs().Item(i).get_Range().get_Font().get_Name();
                if (fontSize == 12.0 && fontName.equals("宋体")){
                    titleContent = titleContent.add(countNum);
                }else{

                    titleContent = titleContent.add(subjectError);
                }

            }
        }
        return titleContent.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // 判断封面
    public BigDecimal firstPage(Application app){

        BigDecimal firstPage = new BigDecimal("0.00000");
        BigDecimal countNum = new BigDecimal("25.0000");
        BigDecimal subjectError = new BigDecimal("0.00000");

        Object o = app.get_ActiveDocument().get_Sections().Item(1).get_Footers().Item(WdHeaderFooterIndex.wdHeaderFooterPrimary).get_Range().get_Information(wdNumberOfPagesInDocument);
        String s = o.toString();
        if (s.equals("3")) {
            firstPage = firstPage.add(countNum);
        }
        if (s != "3"){
            firstPage = firstPage.add(subjectError);
        }
        return firstPage.setScale(2, BigDecimal.ROUND_HALF_UP);
    }



    //文档题目要求
    public String wpsRequirement = "对以下素材按要求进行排版：\n" +
            "(1)为素材加上页眉“WPS办公应用职业技能等级标准”，居中显示，字体大小为宋体小四。\n" +
            "(2)为素材加上页码，从正文开始，样式为“1”，在页脚居中显示。\n" +
            "(3)对素材进行排版，确定标题级别，并自动生成目录。其中标题1为黑体、二号；标题2为黑体三号；标题为3宋体，三号，加粗；正文使用小四号宋体，西文及数字使用小四号Times New Roman字体，1.5倍行距；目录为宋体、小四号字体。\n" +
            "(4)为文档加上封面，内容为“WPS办公应用职业技能等级标准”，效果可自己设计。\n" +
            "每个要求25分，总分100分";

    // wps文字素材内容
    public  String wpsContentText="一、 范围\n" +
            "本标准规定了WPS办公应用职业技能等级对应的工作领域、工作任务及职业技能要求。\n" +
            "本标准适用于WPS办公应用职业技能培训、考核与评价，相关用人单位的人员聘用、培训与考核可参照使用。\n" +
            "二、 规范性引用文件\n" +
            "下列文件对于本标准的应用是必不可少的。凡是注日期的引用文件，仅注日期的版本适用于本标准。凡是不注日期的引用文件，其最新版本适用于本标准。\n" +
            "三、术语和定义 \n" +
            "国家、行业标准界定的以及下列术语和定义适用于本标准。 \n" +
            "1、中文办公软件  Chinese office software\n" +
            "在办公环境中，对中文电子文档进行处理的一套完整的计算机应用程序，主要包括文字排版、电子表格和演示文稿等应用。\n" +
            "2、 工具栏   tool bar\n" +
            "由以按钮图标方式表示的工具构成。 \n" +
            "3、状态栏  status bar\n" +
            "一般位于文档窗口底端,显示命令正在进行的操作以及插入点的位置等信息。 \n" +
            "4、 快捷键  Shortcut key\n" +
            "通过键盘上的一个或者多个按键,可快速完成需要频繁执行的任务。\n" +
            "5、任务窗格  Task Pane\n" +
            "一个可执行特定任务的区域，通常位于窗口的左侧或右侧。\n" +
            "6、 节 section\n" +
            "文字处理文档中最大的排版单元。\n" +
            "7、图表  chart\n" +
            "为直观展现数据，在工作表中用图形方式显示数据的表现形式。\n" +
            "8、 母版  master\n" +
            "演示文稿中为方便制作幻灯片所预先设定的模板，包括式样和布局等内容。\n" +
            "四、 适用院校专业\n" +
            "1、中等职业学校\n" +
            "计算机应用、会计类（办公自动化）、数字媒体技术应用等信息技术类以及学前教育相关专业。\n" +
            "2、高等职业学校\n" +
            "计算机应用等计算机类、文秘等文秘类、会计类（办公自动化）、信息统计与分析等统计类相关专业。\n" +
            "3、应用型本科学校\n" +
            "计算机科学与技术和计算机软件等电子信息类、学前教育等教育学类、文秘教育等职业技术教育类相关专业。\n" +
            "本标准也可作为其他各级各类学校以及用人单位对学生或员工办公软件应用水平的评价参考。\n" +
            "五、 面向职业岗位（群）\n" +
            "主要面向各类企事业单位文秘岗位、需要使用计算机处理工作文档的各类岗位、各级各类学校教育工作者，以及计算机、会计、营销策划等相关技术岗位。其他需要具备办公软件操作能力的岗位也适用本标准。\n" +
            "六、 职业技能要求\n" +
            "1、 职业技能等级划分\n" +
            "WPS办公应用职业技能等级分为三个等级：初级、中级、高级，三个级别依次递进，高级别涵盖低级别职业技能要求。\n" +
            "（1）WPS办公应用初级\n" +
            "主要面向企事业单位专职文员或技术岗位基本技能的需要，能够实现文案的编辑、排版和打印，汇报型演示文稿的制作与演示，应用数据表格对较规范数据的管理、排版打印。\n" +
            "（2）WPS办公应用中级\n" +
            "主要面向企事业单位专职文员或技术岗位基本技能的需要，能够实现长文档的编辑、美化和打印，交互式多媒体演示文稿的制作与演示，应用数据表格对数据的进行相关的数据处理并打印。\n" +
            "（3）WPS办公应用高级\n" +
            "主要面向企事业单位专职文员或技术岗位团队协作的需要，能够实现在线团队协作办公，创意型演示文稿的创作与演讲，应用数据表格对数据的进行数据的可视化处理并打印。\n";




}
