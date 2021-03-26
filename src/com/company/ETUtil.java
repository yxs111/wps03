package com.company;

import com.wps.api.tree.et.Application;
import com4j.Variant;

public class ETUtil {
    //表格题目要求
    public String etRequirement = "按照要求完成“中级电子表格操作题”工作簿相关任务操作：\n" +
            "(1)打开“中级电子表格操作题”工作簿“题1”工作表，使用WPS功能下的【有效性】功能按照下图1对应职务顺序完成职务的填列。\n" +
            "(2)在“题1”工作表完成职务填列后，根据目标序列图2设置自定义序列，并在职务列按照自定义序列完成排序。" +
            "(3)打开“题2”工作表。根据题2资料，在G2单元格使用SUMIF函数计算1月月份在门诊郑医生处就诊的病人人数，在G5单元格使用COUNTIF函数统计卫医生1月份在门诊上班的天数，在D列使用IF函数根据“就诊人数>30人就算超工作量”判断医生们有没有超工作量情况。\n" +
            "(4)打开“题3”工作表。使用MID函数从身份证号中提取生日信息。\n" +
            "(5)打开“题4”工作表。插入组合图，标题为“1月门诊就诊人数占比分析”。图表类型为“簇状柱形图”和“折线图”，折线图为次坐标轴，按照图3样式，绘制组合图\n";

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
