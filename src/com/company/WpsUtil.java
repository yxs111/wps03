package com.company;

import com.wps.api.tree.et.Application;
import com4j.Variant;

public class WpsUtil {


    //文档题目要求
    public String wpsRequirement = "对以下素材按要求进行排版：\n" +
            "(1)为素材加上页眉“WPS办公应用职业技能等级标准”，居中显示，字体大小为宋体小四。\n" +
            "(2)为素材加上页码，从正文开始，格式为“1”，在页脚居中显示。\n" +
            "(3)对素材进行排版，确定标题级别，并自动生成目录。其中标题1为黑体、二号；标题2为黑体三号；标题为3宋体，三号，加粗；正文使用小四号宋体，西文及数字使用小四号Times New Roman字体，1.5倍行距；目录为宋体、小四号字体。\n" +
            "(4)为文档加上封面，内容为“WPS办公应用职业技能等级标准”，效果可自己设计。\n";


    // ppt题目要求
    public String wppRequirement = "打开WPS演示文稿，按要求完成以下操作：\n" +
            "(1)插入第一张版式为只有标题的幻灯片，第二张版式为标题和文本的幻灯片，第三张版式为垂直排列标题和文本的幻灯片，第四张版式为标题和文本的幻灯片，输入文本。所有幻灯片的背景为“填充效果”中的“纹理”中的“褐色大理石”如图。\n" +
            "(2)在第一张幻灯片上插入自选图形（星与旗帜下的横卷形），输入文字如图。\n" +
            "(3)将幻灯片的配色方案设为标题为白色，文本和线条为黄色 。\n" +
            "(4)将母板标题格式设为宋体，44号，加粗。设置文本格式设为华文细黑，32号，加粗，行距为2行，项目符号为z（windings字符集中），桔红色。\n" +
            "(5)在母板的左下角插入剪贴画（宗教-佛教）如图。\n" +
            "(6)设置第一张幻灯片的各个自选图形的填充颜色为无，字体为隶书，48号。在自选图形上加入到对应幻灯片的链接。\n" +
            "(7)设置第一张幻灯片的动画效果：第一个自选图形自左侧切入，随后第二个自选图形自动自右侧切入，第三个自选图形自动自底部切入。\n" +
            "(8)其余3张幻灯片中的每个对象都要设置动画效果，并每张幻灯片之间要有“幻灯片切换效果”。\n" +
            "(9)第2、3、4张幻灯片中加入返回第1张的链接，链接点自己定义，可以在图片上也可在文字上或加按钮都可。\n" +
            "(10)设置全程背景音乐（宗次郎 - 故乡的原风景.mp3）。\n";

    //表格题目要求
    public String etRequirement = "按照要求完成“中级电子表格操作题”工作簿相关任务操作：\n" +
            "(1)打开“中级电子表格操作题”工作簿“题1”工作表，使用WPS功能下的【有效性】功能按照下图1对应职务顺序完成职务的填列。\n" +
            "(2)在“题1”工作表完成职务填列后，根据目标序列图2设置自定义序列，并在职务列按照自定义序列完成排序。" +
            "(3)打开“题2”工作表。根据题2资料，在G2单元格使用SUMIF函数计算1月月份在门诊郑医生处就诊的病人人数，在G5单元格使用COUNTIF函数统计卫医生1月份在门诊上班的天数，在D列使用IF函数根据“就诊人数>30人就算超工作量”判断医生们有没有超工作量情况。\n" +
            "(4)打开“题3”工作表。使用MID函数从身份证号中提取生日信息。\n" +
            "(5)打开“题4”工作表。插入组合图，标题为“1月门诊就诊人数占比分析”。图表类型为“簇状柱形图”和“折线图”，折线图为次坐标轴，按照图3样式，绘制组合图\n";


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


    public void ifText(Application app){
        for (int i = 0 ; i<3 ;i++) {
            app.get_ActiveWorkbook().get_Worksheets().Add(Variant.getMissing(), Variant.getMissing(), Variant.getMissing(), Variant.getMissing(),-i);
            app.get_ActiveWorkbook().get_ActiveSheet().put_Name("题"+ (3-i));
            String sheetName = app.get_ActiveWorkbook().get_ActiveSheet().get_Name();

            if(sheetName.equals("题1")){
                this.ETText1(app);
            }else if(sheetName.equals("题2")){
                this.ETText2(app);
            }else if(sheetName.equals("题3")){
                this.ETText3(app);
            }
        }
    }
    public void ETText1(Application app){
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A1","A1").get_Cells().put_Value2("姓名");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A2","A2").get_Cells().put_Value2("赵医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A3","A3").get_Cells().put_Value2("钱医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A4","A4").get_Cells().put_Value2("孙医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A5","A5").get_Cells().put_Value2("李医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A6","A6").get_Cells().put_Value2("周医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A7","A7").get_Cells().put_Value2("吴医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A8","A8").get_Cells().put_Value2("郑医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A9","A9").get_Cells().put_Value2("王医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A10","A10").get_Cells().put_Value2("冯医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A11","A11").get_Cells().put_Value2("陈医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A12","A12").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A13","A13").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B1","B1").get_Cells().put_Value2("职务");
    }
    public void ETText2(Application app){
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A1","A1").get_Cells().put_Value2("姓名");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A2","A2").get_Cells().put_Value2("赵医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A3","A3").get_Cells().put_Value2("钱医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A4","A4").get_Cells().put_Value2("孙医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A5","A5").get_Cells().put_Value2("李医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A6","A6").get_Cells().put_Value2("周医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A7","A7").get_Cells().put_Value2("吴医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A8","A8").get_Cells().put_Value2("郑医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A9","A9").get_Cells().put_Value2("王医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A10","A10").get_Cells().put_Value2("冯医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A11","A11").get_Cells().put_Value2("陈医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A12","A12").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A13","A13").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B1","B1").get_Cells().put_Value2("1月平均每天就诊人数");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B2","B2").get_Cells().put_Value2("10");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B3","B3").get_Cells().put_Value2("8");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B4","B4").get_Cells().put_Value2("9");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B5","B5").get_Cells().put_Value2("8");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B6","B6").get_Cells().put_Value2("11");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B7","B7").get_Cells().put_Value2("15");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B8","B8").get_Cells().put_Value2("14");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B9","B9").get_Cells().put_Value2("5");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B10","B10").get_Cells().put_Value2("7");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B11","B11").get_Cells().put_Value2("6");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B12","B12").get_Cells().put_Value2("9");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B13","B13").get_Cells().put_Value2("8");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C1","C1").get_Cells().put_Value2("1月上班天数");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C2","C2").get_Cells().put_Value2("22");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C3","C3").get_Cells().put_Value2("25");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C4","C4").get_Cells().put_Value2("23");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C5","C5").get_Cells().put_Value2("21");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C6","C6").get_Cells().put_Value2("20");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C7","C7").get_Cells().put_Value2("11");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C8","C8").get_Cells().put_Value2("19");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C9","C9").get_Cells().put_Value2("18");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C10","C10").get_Cells().put_Value2("22");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C11","C11").get_Cells().put_Value2("25");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C12","C12").get_Cells().put_Value2("29");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C13","C13").get_Cells().put_Value2("27");
    }
    public void ETText3(Application app){

        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A1","A1").get_Cells().put_Value2("姓名");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A2","A2").get_Cells().put_Value2("赵医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A3","A3").get_Cells().put_Value2("钱医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A4","A4").get_Cells().put_Value2("孙医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A5","A5").get_Cells().put_Value2("李医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A6","A6").get_Cells().put_Value2("周医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A7","A7").get_Cells().put_Value2("吴医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A8","A8").get_Cells().put_Value2("郑医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A9","A9").get_Cells().put_Value2("王医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A10","A10").get_Cells().put_Value2("冯医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A11","A11").get_Cells().put_Value2("陈医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A12","A12").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A13","A13").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B1","B1").get_Cells().put_Value2("身份证");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B2","B2").get_Cells().put_Value2("410901199802172012");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B3","B3").get_Cells().put_Value2("410901199502172017");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B4","B4").get_Cells().put_Value2("410901199806272018");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B5","B5").get_Cells().put_Value2("410901199402172025");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B6","B6").get_Cells().put_Value2("410901199202172047");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B7","B7").get_Cells().put_Value2("410901199702172025");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B8","B8").get_Cells().put_Value2("410901199412172147");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B9","B9").get_Cells().put_Value2("410901199712172147");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B10","B10").get_Cells().put_Value2("410901198803172755");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B11","B11").get_Cells().put_Value2("410901198803162582");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B12","B12").get_Cells().put_Value2("410901198803272724");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B13","B13").get_Cells().put_Value2("410901198804252762");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C1","C1").get_Cells().put_Value2("生日");
    }



}
