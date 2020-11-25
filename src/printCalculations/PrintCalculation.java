package printCalculations;

import equation.Equation;

import java.util.Scanner;

import static context.NUM.NUM;

//此模块用来输出答案判断对错
public class PrintCalculation {
    public static void print_Calculations(Equation[] equations, int[] inans){
        int i,j=0;
        //计算答案
        for (i = 0; i < NUM; i++) {
            if(equations[i].getOperator()==1){
                equations[i].setAnswer(equations[i].getFirst()+equations[i].getSecond());
            }else {
                equations[i].setAnswer((equations[i].getFirst()-equations[i].getSecond()));
            }
        }
        //判断对错
        for (i = 0; i < NUM; i++) {
            if(inans[i]==equations[i].getAnswer()){
                System.out.print(""+"正确"+"\t\t");
            }
            if(inans[i]!=equations[i].getAnswer()){
                System.out.print(""+"错误"+"\t\t");
            }
            j++;
            if (j%4==0){
                System.out.println();
            }
        }
        System.out.println();
        //打印答案
        System.out.println("下面是习题的参考答案:");
        j=0;
        for (i = 0; i <NUM; i++) {
            System.out.print(""+(i+1)+":"+ equations[i].getAnswer()+"\t");
            j++;
            if (j%4==0){
                System.out.println();
            }
        }
    }
    //用于测试
    public static void main(String[] args) {
        System.out.println("请输入算式的数量：");
        Scanner in=new Scanner(System.in);
        NUM=in.nextInt();
        Equation[] equationstext=new Equation[NUM];
        for (int i = 0; i < NUM; i++) {
            equationstext[i]= new Equation();
        }
        int[] inanstest={1,2,3,4,5,6,7};
        PrintCalculation.print_Calculations(equationstext,inanstest);
    }
}

