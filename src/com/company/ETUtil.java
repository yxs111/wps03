package com.company;

import com.wps.api.tree.et.Application;
import com4j.Variant;

import java.math.BigDecimal;

public class ETUtil {


    public BigDecimal subjectOne(Application app){
        BigDecimal subjectOne = new BigDecimal("0.0000");
        BigDecimal count = new BigDecimal("2.08333");
        int sheetCount = app.get_Columns().get_Range("B2","B13").get_Count();
        for (int i = 2 ; i<= (sheetCount+1) ; i ++){
            String countText =  app.get_Columns().get_Range("B"+i ,"B"+i ).get_Text().toString();
            if(i == 4 || i == 5 || i == 6){
                if (countText.equals("副主任医师")){
                    subjectOne = subjectOne.add(count);
                }
            }
            if (i == 7 || i == 8 || i == 9){
                if (countText.equals("主治医师")){
                    subjectOne = subjectOne.add(count);
                }
            }
            if (i == 2 || i == 3){
                if (countText.equals("主任医师")){
                    subjectOne = subjectOne.add(count);
                }
            }
            if (i == 10 || i == 11 || i == 12 || i == 13 ){
                if (countText.equals("住院医师")){
                    subjectOne = subjectOne.add(count);
                }
            }

        }
        return subjectOne.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal subjectTow(Application app){
        BigDecimal subjectTow = new BigDecimal("0.00000");
        BigDecimal count = new BigDecimal("8.33333");
        BigDecimal countIF = new BigDecimal("0.2688");
        String formulaArrayG2 = app.get_Columns().get_Range("G2" ,"G2").get_FormulaArray().toString();
        String formulaArrayG5 = app.get_Columns().get_Range("G5","G5").get_FormulaArray().toString();
        if(formulaArrayG2.equals("=SUMIF(A2:A32,F2,B2:B32)")){
            subjectTow = subjectTow.add(count);
        }
        if(formulaArrayG5.equals("=COUNTIF(A2:A32,F5)")){
            subjectTow = subjectTow.add(count);
        }
        int sheetCount = app.get_Columns().get_Range("B2","B32").get_Count();
        String egFormulaArray = "" ;
        for (int i = 2 ; i <= (sheetCount+1) ; i ++){
            String countText =  app.get_Columns().get_Range("D"+i ,"D"+i ).get_Text().toString();
            if(countText != "" && countText != null){
                String formulaArray = app.get_Columns().get_Range("D"+i ,"D"+i).get_FormulaArray().toString();
                egFormulaArray = "=IF(B"+i+":B"+(30+i)+">30,\"超量\",\"正常\")";
                if (formulaArray.equals(egFormulaArray)){
                    subjectTow = subjectTow.add(countIF);
                }
            }
        }

        return subjectTow.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal subjectThree(Application app){
        BigDecimal subjectThree = new BigDecimal("0.0000");
        BigDecimal count = new BigDecimal("2.08333");
        String egFormulaArray = "" ;
        // 获取指定单元格内的函数
        int sheetCount = app.get_Columns().get_Range("C2","C13").get_Count();
        for (int i = 2 ; i <= (sheetCount+1) ; i ++){
           String countText =  app.get_Columns().get_Range("C"+i ,"C"+i ).get_Text().toString();
           if(countText != "" && countText != null){
               String formulaArray = app.get_Columns().get_Range("C"+i ,"C"+i).get_FormulaArray().toString();
               egFormulaArray = "=MID(B"+i+",7,8)";
               if (formulaArray.equals(egFormulaArray)){
                   subjectThree = subjectThree.add(count);
               }
           }
        }

        return subjectThree.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public double subjectFour(Application app){
        double subjectFour = 0.00;
        return subjectFour;
    }


    //表格题目要求
    public String etRequirement =
            "(1)打开“中级电子表格操作题”工作簿“题1”工作表，使用WPS功能下的【有效性】功能按照下图1对应职务顺序完成职务的填列。" +
            "在“题1”工作表完成职务填列后，根据目标序列图2设置自定义序列，并在职务列按照自定义序列完成排序。\n" +
            "(2)打开“题2”工作表。根据题2资料，在G2单元格以F2为条件单元格使用SUMIF函数计算1月月份在门诊郑医生处就诊的病人人数，在G5单元格以F5为条件单元格使用COUNTIF函数统计卫医生1月份在门诊上班的天数，在D列使用IF函数根据“每天就诊人数>30人就算超工作量”，以“超量”，“正常”表示判断医生们有没有超工作量情况。\n" +
            "(3)打开“题3”工作表。使用MID函数从身份证号中提取生日信息。\n"+
            "(4)打开“题4”工作表。插入组合图，标题为“1月门诊就诊人数占比分析”。图表类型为“簇状柱形图”和“折线图”，折线图为次坐标轴，按照图3样式，绘制组合图\n" +
            "每个题25，总分100分";

    // 素材加载方法
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
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A13","A13").get_Cells().put_Value2("卫医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A14","A14").get_Cells().put_Value2("赵医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A15","A15").get_Cells().put_Value2("钱医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A16","A16").get_Cells().put_Value2("孙医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A17","A17").get_Cells().put_Value2("李医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A18","A18").get_Cells().put_Value2("周医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A19","A19").get_Cells().put_Value2("吴医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A20","A20").get_Cells().put_Value2("郑医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A21","A21").get_Cells().put_Value2("王医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A22","A22").get_Cells().put_Value2("冯医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A23","A23").get_Cells().put_Value2("陈医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A24","A24").get_Cells().put_Value2("诸医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A25","A25").get_Cells().put_Value2("卫医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A26","A26").get_Cells().put_Value2("赵医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A27","A27").get_Cells().put_Value2("钱医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A28","A28").get_Cells().put_Value2("孙医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A29","A29").get_Cells().put_Value2("李医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A30","A30").get_Cells().put_Value2("周医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A31","A31").get_Cells().put_Value2("卫医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("A32","A32").get_Cells().put_Value2("卫医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B1","B1").get_Cells().put_Value2("每天就诊人数");
        for(int i = 2 ; i <= 32 ; i ++  ) {
            app.get_ActiveWorkbook().get_ActiveSheet().get_Range("B" + i, "B" + i).get_Cells().put_Value2(i);
        }
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C1","C1").get_Cells().put_Value2("1月出勤/日期");
        for(int i = 2 ; i <= 32 ; i ++  ) {
            app.get_ActiveWorkbook().get_ActiveSheet().get_Range("C" + i, "C" + i).get_Cells().put_Value2(i - 1);
        }
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("F2","F2").get_Cells().put_Value2("郑医生");
        app.get_ActiveWorkbook().get_ActiveSheet().get_Range("F5","F5").get_Cells().put_Value2("卫医生");
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
