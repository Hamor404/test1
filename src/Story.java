
import static context.NUM.NUM;

import equation.Equation;
import generateEquations.GenerateEquations;
import printHeader.PrintHeader;
import printExercuise.PrintExercuise;
import printCalculations.PrintCalculation;
import writeAns.WriteAns;
import java.util.Scanner;

//主函数
public class Story {
    public static void main(String[] args){
        System.out.println("请输入题目的数量：");
        Scanner in=new Scanner(System.in);
        NUM=in.nextInt();
        PrintHeader.print_Header();
        Equation[] equations1 = GenerateEquations.generate_Equations();
        Equation[] equations2= PrintExercuise.print_Exercuise(equations1);
        int[] inans= WriteAns.write_Ans();
        PrintCalculation.print_Calculations(equations2,inans);
    }
}
