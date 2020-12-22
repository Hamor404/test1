package main;

import static context.NUM.NUM;
import csvfile.CsvFile;
import equation.AdditionEquations;
import equation.Equation;
import exercise.Exercise;
import printHeader.PrintHeader;
import writeAns.WriteAns;

import java.io.IOException;
import java.util.Scanner;


// 主函数
public class Story {
    public static void main(String[] args) {
        int select;
        Exercise exercise = new Exercise();
        Equation[] equation = new AdditionEquations[5*NUM];
        select = PrintHeader.print_Header();
        CsvFile csvFile = new CsvFile();
        switch (select) {
            case 1:
                equation = exercise.gernAddequation(5*NUM);
                csvFile.writeEquationsfile(equation);
                break;
            case 2:
                equation = exercise.gernSubequation(5*NUM);
                csvFile.writeEquationsfile(equation);
                break;
            case 3:
                equation = exercise.gernequatExercise(5*NUM);
                csvFile.writeEquationsfile(equation);

                break;
            default:
        }


        Equation[] exercises = new AdditionEquations[3*NUM];
        System.out.println("是否继续上次的未完成的题目？");
        System.out.println("1.是   2.否");
        Scanner in = new Scanner(System.in);
        select = in.nextInt();
        if (select==1){
            try {
                exercises=csvFile.readExercisesfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                equation=csvFile.readEquationsfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            csvFile.writeExercisesfile(equation);
            try {
                exercises=csvFile.readExercisesfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("第"+(i+1)+"套题：");
            exercise.print_Exercuise(exercises,i);
        }


        int inans[]=new int[3*NUM];
        for (int i = 0; i < 3*NUM; i++) {
            inans[i]=-1;
        }
        int n=0;
        if (select==1){
            try {
                inans=csvFile.readinansfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (inans[n]!=-1){
                n++;
                if (n==3*NUM-1&&inans[n]==-1){
                    break;
                }else if(n==3*NUM-1&&inans[n]!=-1){
                    n++;
                    break;
                }
            }
        }
        System.out.println();
        inans=WriteAns.write_Ans(inans,n);
        csvFile.writeinansfile(inans);
        n=0;
        while (inans[n]!=-1){
            n++;
            if (n==3*NUM-1&&inans[n]==-1){
                break;
            }else if(n==3*NUM-1&&inans[n]!=-1){
                n++;
                break;
            }
       }
       if (n==3*NUM){
           for (int i = 0; i < 3; i++) {
               System.out.println();
               System.out.println();
               System.out.println("第"+(i+1)+"套题：");
               exercise.print_Calculations(exercises,inans,i);
           }
       }else {
           System.out.println("程序被用户终止");
       }

    }
}
