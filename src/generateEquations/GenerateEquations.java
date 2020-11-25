package generateEquations;


import equation.Equation;

import static context.NUM.NUM;
import java.util.Random;
import java.util.Scanner;

//此模块用于控制加减法
public class GenerateEquations {
    public static Equation[] generate_Equations() {
        Equation[] equations=new Equation[NUM];
        for (int i = 0; i < NUM; i++) {
            equations[i]= new Equation();
        }
        int nums=0,add_nums=0;
        Random random = new Random();
        while(nums<NUM){
            equations[nums].setOperator((short) random.nextInt(2));
            //控制加减法的数量各占一半
            if(equations[nums].getOperator()==1){
                add_nums++;
            }
            if(add_nums>(NUM/2)){
                equations[nums].setOperator((short) 0);
            }
            nums++;
        }

        return equations;
    }
    //用于测试
   public static void main(String[] args) {
        int add=0,sub=0;
       System.out.println("请输入算式的数量：");
       Scanner in=new Scanner(System.in);
       NUM=in.nextInt();
        Equation[] ovtest=GenerateEquations.generate_Equations();
       for (int i = 0; i < NUM; i++) {
            if (ovtest[i].getOperator()==1){
                add++;
            }else {
                sub++;
            }
       }
       System.out.println("生成加法"+add+"个"+",生成减法"+sub+"个");
    }
}