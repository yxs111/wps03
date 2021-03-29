package com.company;

import com.wps.api.tree.wpp.Application;

import java.math.BigDecimal;

import static com.wps.api.tree.wpp.MsoTriState.msoFalse;

public class WppUtil {
    public BigDecimal subjectOne(Application app){
        BigDecimal subjectOne = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("1.2500");
        BigDecimal allCountNum = new BigDecimal("2.5000");
        BigDecimal allError = new BigDecimal("0.0000");
        // 获取演示文稿中PPT总张数
        int wppCount = app.get_ActivePresentation().get_Slides().get_Count();
        if(wppCount >= 4){
            for(int i = 1 ;i <= wppCount ; i ++ ){
                // 获取ppt版式
                String wppLayoutName = app.get_ActivePresentation().get_Slides().Item(i).get_Layout().name();
                // 获取ppt背景填充样式，可以获取name也可以获取comEnumValue背景所代表的值
                String presetStyle = app.get_ActivePresentation().get_Slides().Item(i).get_Background().get_Fill().get_PresetTexture().name();
                if(i==1){
                    if (wppLayoutName.equals("ppLayoutTitle") && presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutTitle" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }
                if(i==2 || i==4){
                    if (wppLayoutName.equals("ppLayoutObject") && presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutObject" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }
                if(i==3){
                    if (wppLayoutName.equals("ppLayoutVerticalTitleAndText") && presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutVerticalTitleAndText" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }

            }
        }


        return subjectOne.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectTwo(Application app){
        BigDecimal subjectTwo = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("3.333333");
        int autoShapeCount = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Count();
        for (int i = 1; i <= autoShapeCount ; i ++){
            String autoShapeName = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i+1).get_AutoShapeType().name();
            String contentText = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i+1).get_TextFrame().get_TextRange().get_Text();
            if(autoShapeName.equals("msoShapeHorizontalScroll") && contentText != null &&contentText != ""){
                subjectTwo = subjectTwo.add(countNum);
            }
        }
        return subjectTwo.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    // 第一张ppt把元素是否包含文字设置成false
    /*public void hasTextFrame(Application app){
        int count = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Count();
        System.out.println(count);
        for (int i = 2;2 <= count ; i++){
            int type = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i).get_HasTextFrame().compareTo(msoFalse);
            System.out.println(type);
        }
    }*/
    public BigDecimal subjectThree(Application app){
        BigDecimal subjectThree = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("1.2500");
        BigDecimal allCountNum = new BigDecimal("2.5000");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        for(int i = 1 ; i <=count ; i++){
            // 标题字体颜色
            int titleFontColor = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Color().get_RGB();
            int textFontColor = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(i).get_TextFrame().get_TextRange().get_Font().get_Color().get_RGB();
            if(i == 1){
                if (titleFontColor == 16777215){
                    subjectThree = subjectThree.add(allCountNum);
                }
            }
            if(i != 1){
                if (titleFontColor == 16777215 && textFontColor == 65535){
                    subjectThree = subjectThree.add(allCountNum);
                }
                if(titleFontColor == 16777215 || textFontColor == 65535){
                    subjectThree = subjectThree.add(countNum);
                }
            }
        }
        int ShapeCount = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Count();
        return subjectThree.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectFour(Application app){
        BigDecimal subjectFour = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("2.5000");
        BigDecimal allCountNum = new BigDecimal("5.0000");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        for (int i = 1 ; i <= count ; i ++ ){
            // 标题的字体样式，大小，加粗
            String titleFontStyle = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Name();
            float titleFontSize = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Size();
            String titleFontBold = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().get_Title().get_TextFrame().get_TextRange().get_Font().get_Bold().name();

            // 正文的字体样式，大小，加粗
            String textFontStyle = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(2).get_TextFrame().get_TextRange().get_Font().get_Name();
            float textFontSize = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(2).get_TextFrame().get_TextRange().get_Font().get_Size();
            String textFontBold = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(2).get_TextFrame().get_TextRange().get_Font().get_Bold().name();
            if(i == 1){
                if (titleFontStyle.equals("宋体") && titleFontSize == 44.0 && titleFontBold.equals("msoTrue")) {
                    subjectFour = subjectFour.add(allCountNum);
                }
            }
            if(i != 1){
                if (titleFontStyle.equals("宋体") && titleFontSize == 44.0 && titleFontBold.equals("msoTrue")) {
                    subjectFour = subjectFour.add(countNum);
                }
                if (textFontStyle.equals("华文细黑") && textFontSize == 32.0 && textFontBold.equals("msoTrue")) {
                    subjectFour = subjectFour.add(countNum);
                }
            }
        }
        return subjectFour.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectFive(Application app){
        BigDecimal subjectFive = new BigDecimal("0.0000");
        return subjectFive.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectSix(Application app){
        BigDecimal subjectSix = new BigDecimal("0.0000");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        return subjectSix.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectSeven(Application app){
        BigDecimal subjectSeven = new BigDecimal("0.0000");
        return subjectSeven.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectEight(Application app){
        BigDecimal subjectEight = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("3.333333");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        for(int i = 2 ; i <= count ; i ++){
            String effectName  = app.get_ActivePresentation().get_Slides().Item(i).get_SlideShowTransition().get_EntryEffect().name();
            if(!effectName.equals("ppEffectNone")){
                subjectEight = subjectEight.add(countNum);
            }
        }
        return subjectEight.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectNine(Application app){
        BigDecimal subjectNine = new BigDecimal("0.0000");
        return subjectNine.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectTen(Application app){
        BigDecimal subjectTen = new BigDecimal("0.0000");
        return subjectTen.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // ppt题目要求
    public String wppRequirement = "打开WPS演示文稿，按要求完成以下操作：\n" +
            "(1)插入第一张版式为只有标题的幻灯片，第二张版式为标题和文本的幻灯片，第三张版式为垂直排列标题和文本的幻灯片，第四张版式为标题和文本的幻灯片，输入文本。所有幻灯片的背景为“填充效果”中的“纹理”中的“皮革”\n" +
            "(2)在第一张幻灯片上插入自选图形（星与旗帜下的横卷形），输入文字如图。\n" +
            "(3)将幻灯片的配色方案设为标题为白色，文本和线条为黄色 。\n" +
            "(4)将母板标题格式设为宋体，44号，加粗。设置文本格式设为华文细黑，32号，加粗，行距为2行，项目符号为z（windings字符集中）。\n" +
            "(5)在母板的左下角插入剪贴画（宗教-佛教）如图。\n" +
            "(6)设置第一张幻灯片的各个自选图形的填充颜色为无，字体为隶书，48号。在自选图形上加入到对应幻灯片的链接。\n" +
            "(7)设置第一张幻灯片的动画效果：第一个自选图形自左侧切入，随后第二个自选图形自动自右侧切入，第三个自选图形自动自底部切入。\n" +
            "(8)其余3张幻灯片中的每个对象都要设置动画效果，并每张幻灯片之间要有“幻灯片切换效果”。\n" +
            "(9)第2、3、4张幻灯片中加入返回第1张的链接，链接点自己定义，可以在图片上也可在文字上或加按钮都可。\n" +
            "(10)设置全程背景音乐（宗次郎 - 故乡的原风景.mp3）。\n";
}
