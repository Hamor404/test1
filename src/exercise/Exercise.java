package exercise;

import equation.AdditionEquations;
import equation.Equation;
import equation.SubstractEquations;

import java.util.Random;

import static context.NUM.NUM;

public class Exercise {
    public Equation gernOperator() {
        Random random = new Random();
        short oper = (short) random.nextInt(2);
        if (oper == 1) {
            AdditionEquations addequation = new AdditionEquations();
            addequation.setOperator(oper);
            return addequation;
        } else {
            SubstractEquations subequation = new SubstractEquations();
            subequation.setOperator(oper);
            return subequation;
        }
    }

    public Equation[] gernAddequation(int NUM) {
        AdditionEquations[] addequations = new AdditionEquations[NUM];
        for (int i = 0; i <NUM ; i++) {
            addequations[i]=new AdditionEquations();
        }
        int nums = 0;
        //用于确保算式的答案在0~100以内
        while (nums < NUM) {
            addequations[nums].gernEquat((short) 1);
            addequations[nums].setAnswer(addequations[nums].Calculation());
            if (addequations[nums].getAnswer() >= 0 && addequations[nums].getAnswer() <= 100) {
                nums++;
            }
            //用于确保没有重复的算式
            if (nums != 1) {
                for (int i = 0; i < nums - 1; i++) {
                    if (addequations[i] == addequations[nums - 1]) {
                        nums--;
                        break;
                    }
                }
            }
        }
        return addequations;
    }

    public Equation[] gernSubequation(int NUM) {
        SubstractEquations[] subequations = new SubstractEquations[NUM];
        for (int i = 0; i < NUM; i++) {
            subequations[i]=new SubstractEquations();
        }
        int nums = 0;
        //用于确保算式的答案在0~100以内
        while (nums < NUM) {
            subequations[nums].gernEquat((short) 0);
            subequations[nums].setAnswer(subequations[nums].Calculation());
            if (subequations[nums].getAnswer() >= 0 && subequations[nums].getAnswer() <= 100) {
                nums++;
            }
            //用于确保没有重复的算式
            if (nums != 1) {
                for (int i = 0; i < nums - 1; i++) {
                    if (subequations[i] == subequations[nums - 1]) {
                        nums--;
                        break;
                    }
                }
            }
        }
        return subequations;
    }

    public Equation[] gernequatExercise(int NUM) {
        Exercise exercise = new Exercise();
        Equation[] equations = new AdditionEquations[NUM];

        AdditionEquations fequation=new AdditionEquations();
        SubstractEquations sequation= new SubstractEquations();
        for (int i = 0; i < NUM; i++) {
            equations[i]=new AdditionEquations();
        }
        int nums = 0;
        //用于确保算式的答案在0~100以内
        while (nums < NUM) {
            equations[nums].gernEquat(exercise.gernOperator().getOperator());
            if (equations[nums].getOperator() == (short) 1) {
                fequation.setFirst(equations[nums].getFirst());
                fequation.setSecond(equations[nums].getSecond());
                fequation.setOperator(equations[nums].getOperator());
                equations[nums].setAnswer(fequation.Calculation());
            } else if (equations[nums].getOperator() == (short) 0) {
                sequation.setFirst(equations[nums].getFirst());
                sequation.setSecond(equations[nums].getSecond());
                sequation.setOperator(equations[nums].getOperator());
                equations[nums].setAnswer(sequation.Calculation());
            }
            if (equations[nums].getAnswer() >= 0 && equations[nums].getAnswer() <= 100) {
                nums++;
            }
            //用于确保没有重复的算式
            if (nums != 1) {
                for (int i = 0; i < nums - 1; i++) {
                    if (equations[i] == equations[nums - 1]) {
                        nums--;
                        break;
                    }
                }
            }
        }
        return equations;
    }
    public void print_Exercuise(Equation[] equations){
        char o;
        int j=0;
        for (int i=0;i< NUM;i++ ){
            if(equations[i].getOperator()==1){
                o='+';
            }else {
                o='-';
            }
            if(j%4==0) {
                System.out.println();
            }
            System.out.print("" + (i + 1) + ":\t" + equations[i].getFirst() + o + equations[i].getSecond() + "=\t");
            j++;
        }
        System.out.println();
    }
    public void print_Calculations(Equation[] equation,int[] inans){
        int i,j=0;
        //判断对错
        for ( i = 0; i < NUM; i++) {
            if(equation[i].ChkAnswer(inans[i])){
                System.out.print(""+"正确"+"\t\t");
            }else {
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
            System.out.print(""+(i+1)+":"+ equation[i].getAnswer()+"\t");
            j++;
            if (j%4==0){
                System.out.println();
            }
        }
    }
}
