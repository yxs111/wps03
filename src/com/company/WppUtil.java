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
        int count = app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
            for(int i = 1 ;i <= count ; i ++ ){
                // 获取ppt版式
                String wppLayoutName = app.get_ActivePresentation().get_Slides().Item(i).get_Layout().name();
                // 获取ppt背景填充样式，可以获取name也可以获取comEnumValue背景所代表的值
                String presetStyle = app.get_ActivePresentation().get_Slides().Item(i).get_Background().get_Fill().get_PresetTexture().name();
                // 获取标题文本
                String titleText = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(1).get_TextFrame().get_TextRange().get_Text();
                // 获取段落文本
                String contentText = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(2).get_TextFrame().get_TextRange().get_Text();
                if(i==1){
                    if (wppLayoutName.equals("ppLayoutTitle") && presetStyle.equals("msoTexturePaperBag") && titleText.equals("回乡偶书")){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutTitle" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }
                if(i==2){
                    if (wppLayoutName.equals("ppLayoutObject") && presetStyle.equals("msoTexturePaperBag") && titleText.equals("内容简介") && contentText.equals(pptTowContentText)){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutObject" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }
                if(i==3){
                    if (wppLayoutName.equals("ppLayoutVerticalTitleAndText") && presetStyle.equals("msoTexturePaperBag") && titleText.equals("诗文欣赏")&& contentText.equals(pptThreeContentText)){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutVerticalTitleAndText" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }
                if(i==4){
                    if (wppLayoutName.equals("ppLayoutObject") && presetStyle.equals("msoTexturePaperBag") && titleText.equals("作者简介")&& contentText.equals(pptFourContentText)){
                        subjectOne = subjectOne.add(allCountNum);
                    }
                    if(wppLayoutName.equals("ppLayoutObject" ) || presetStyle.equals("msoTexturePaperBag")){
                        subjectOne = subjectOne.add(countNum);
                    }
                }

            }
        }catch (Exception e){
            subjectOne = subjectOne.add(allError);
        }




        return subjectOne.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectTwo(Application app){
        BigDecimal subjectTwo = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("3.333333");
        BigDecimal allError = new BigDecimal("0.0000");
        int autoShapeCount = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Count();
        try{
            if(autoShapeCount > 7){
                autoShapeCount = 7;
            }
            for (int i = 1; i <= autoShapeCount ; i ++){
                String autoShapeName = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i+1).get_AutoShapeType().name();
                String contentText = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i+1).get_TextFrame().get_TextRange().get_Text();
                if(autoShapeName.equals("msoShapeHorizontalScroll") && contentText != null &&contentText != ""){
                    subjectTwo = subjectTwo.add(countNum);
                }
            }
        }catch (Exception e){
            subjectTwo = subjectTwo.add(allError);
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
        BigDecimal allError = new BigDecimal("0.0000");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
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
        }catch (Exception e){
            subjectThree = subjectThree.add(allError);
        }

        int ShapeCount = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Count();
        return subjectThree.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectFour(Application app){
        BigDecimal subjectFour = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("2.5000");
        BigDecimal allCountNum = new BigDecimal("5.0000");
        BigDecimal allError = new BigDecimal("0.0000");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
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
        }catch (Exception e){
            subjectFour = subjectFour.add(allError);
        }

        return subjectFour.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectFive(Application app){
        BigDecimal subjectFive = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("2.5000");
        BigDecimal allError = new BigDecimal("0.0000");
        int count = app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
            for (int i = 1 ; i<= count ; i++){
                int shapeCount =  app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().get_Count();
                for (int j = 1 ; j <= shapeCount ;j++){
                    int shapeType = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(j).get_Type().comEnumValue();
                    String shapeName = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(j).get_Name().substring(0,2);
                    // 判断元素类型 13为图片
                    if (shapeType == 13 && shapeName.equals("图片")){
                        subjectFive = subjectFive.add(countNum);
                    }
                }
            }
        }catch (Exception e){
            subjectFive = subjectFive.add(allError);
        }
        return subjectFive.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectSix(Application app){
        BigDecimal subjectSix = new BigDecimal("0.0000");
        BigDecimal allCountNum = new BigDecimal("10.0000");
        BigDecimal allError = new BigDecimal("0.0000");
        // 第一张PPT的元素个数
        int count= app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
            for(int i = 2 ; i <= count ; i ++){
                String contentFontName = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i).get_TextFrame().get_TextRange().get_Font().get_Name();
                float contentFontSize = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i).get_TextFrame().get_TextRange().get_Font().get_Size();
                int fillCount = app.get_ActivePresentation().get_Slides().Item(1).get_Shapes().Item(i).get_Fill().get_Visible().comEnumValue();
                String screenSt = app.get_ActivePresentation().get_Slides().Item(1).get_Hyperlinks().Item(i-1).get_SubAddress();
                String iSt = String.valueOf(i);
                char cNum = screenSt.charAt(10);
                if(contentFontName.equals("隶书") && contentFontSize == 48.0 && fillCount == 0 && cNum == iSt.charAt(0)){
                    subjectSix = subjectSix.add(allCountNum);
                }
            }
        }catch (Exception e){
            subjectSix = subjectSix.add(allError);
        }

        return subjectSix.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // 方法待定
    public BigDecimal subjectSeven(Application app){
        BigDecimal subjectSeven = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("3.33333");
        BigDecimal allError = new BigDecimal("0.0000");
        int effectCount = app.get_ActivePresentation().get_Slides().Item(1).get_TimeLine().get_MainSequence().get_Count();
        try{

            if(effectCount != 0){
                if (effectCount > 3){
                    effectCount = 3;
                }
                for (int i = 1; i <= effectCount ; i++){
                    subjectSeven = subjectSeven.add(countNum);
                }
            }
            if (effectCount == 0){
                subjectSeven = subjectSeven.add(allError);
            }

        }catch (Exception e){
            subjectSeven = subjectSeven.add(allError);
        }
        return subjectSeven.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectEight(Application app){
        BigDecimal subjectEight = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("3.333333");
        BigDecimal allError = new BigDecimal("0.0000");
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
            for(int i = 2 ; i <= count ; i ++){
                String effectName  = app.get_ActivePresentation().get_Slides().Item(i).get_SlideShowTransition().get_EntryEffect().name();
                if(!effectName.equals("ppEffectNone")){
                    subjectEight = subjectEight.add(countNum);
                }
            }
        }catch (Exception e){
            subjectEight = subjectEight.add(allError);
        }

        return subjectEight.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectNine(Application app){
        BigDecimal subjectNine = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("3.333333");
        BigDecimal allError = new BigDecimal("0.0000");
        // 获取幻灯片总张数
        int count= app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
            for (int i = 2 ;i <= count ; i++){
                int hyperlinkCount = app.get_ActivePresentation().get_Slides().Item(i).get_Hyperlinks().get_Count();
                String screenSt = app.get_ActivePresentation().get_Slides().Item(i).get_Hyperlinks().Item(1).get_SubAddress();
                String iSt = String.valueOf(1);
                char cNum = screenSt.charAt(10);
                if(hyperlinkCount != 0 && cNum == iSt.charAt(0)){
                    subjectNine = subjectNine.add(countNum);
                }
            }
        }catch (Exception e){
            subjectNine = subjectNine.add(allError);
        }
        return subjectNine.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectTen(Application app){
        BigDecimal subjectTen = new BigDecimal("0.0000");
        BigDecimal countNum = new BigDecimal("2.5000");
        BigDecimal allError = new BigDecimal("0.0000");
        int count = app.get_ActivePresentation().get_Slides().get_Count();
        try{
            if (count > 4){
                count = 4;
            }
            for(int i = 1 ;i <= count ;i++){
                int shapeCount =  app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().get_Count();
                for (int m = 1 ;m <= shapeCount ; m ++){
                    int musicCount = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(m).get_Type().comEnumValue();
                    String musicName = app.get_ActivePresentation().get_Slides().Item(i).get_Shapes().Item(m).get_Name();
                    // 判断元素类型 16为音频
                    if (musicName.equals("宗次郎 - 故乡的原风景") && musicCount == 16){
                        subjectTen = subjectTen.add(countNum);
                    }
                }
            }
        }catch (Exception e){
            subjectTen = subjectTen.add(allError);
        }

        return subjectTen.setScale(2, BigDecimal.ROUND_HALF_UP);
    }










    // 段落内容
    public String pptTowContentText = "\uF07A诗人从乡音不改，儿童不识上抒发了自己对似水流年的感慨之情。";
    public String pptThreeContentText = "\uF07A笑问客从何处来\n";
    public String pptFourContentText = "\uF07A其诗今存十九首，绝句淡而有味，时出巧思。\n";

    // ppt题目要求
    public String wppRequirement = "打开WPS演示文稿，按要求完成以下操作：\n" +
            "(1)插入第一张版式为只有标题的幻灯片，第二张版式为标题和文本的幻灯片，第三张版式为垂直排列标题和文本的幻灯片，第四张版式为标题和文本的幻灯片，在同一个文本框内输入文本。所有幻灯片的背景为“填充效果”中的“纹理”中的“皮革”\n" +
            "(2)在第一张幻灯片上插入自选图形（星与旗帜下的横卷形）。\n" +
            "(3)将幻灯片的配色方案设为标题为白色，文本和线条为黄色 。\n" +
            "(4)将母板标题格式设为宋体，44号，加粗。设置文本格式设为华文细黑，32号，加粗。\n" +
            "(5)在母板的左下角插入剪贴画。\n"+
            "(6)设置第一张幻灯片的各个自选图形的填充颜色为无，字体为隶书，48号。在自选图形上加入到对应幻灯片的链接。\n" +
            "(7)设置第一张幻灯片的动画效果：第一个自选图形自左侧切入，随后第二个自选图形自动自右侧切入，第三个自选图形自动自底部切入。\n" +
            "(8)其余3张幻灯片中的每个对象都要设置动画效果，并每张幻灯片之间要有“幻灯片切换效果”。\n" +
            "(9)第2、3、4张幻灯片中加入返回第1张的链接，链接点自己定义，可以在图片上也可在文字上或加按钮都可。\n" +
            "(10)设置全程背景音乐（宗次郎 - 故乡的原风景.mp3）。\n";
}
