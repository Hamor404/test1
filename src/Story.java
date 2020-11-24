
import static context.NUM.NUM;
import generateEquations.GenerateEquations;
import printHeader.PrintHeader;
import printExercuise.PrintExercuise;
import printCalculations.PrintCalculation;
import writeAns.WriteAns;
import java.util.Scanner;

public class Story {
    public static void main(String[] args){
        System.out.println("请输入题目的数量：");
        Scanner in=new Scanner(System.in);
        NUM=in.nextInt();
        PrintHeader.print_Header();
        short[] ov = GenerateEquations.generate_Equations();
        short[][] qus= PrintExercuise.print_Exercuise(ov);
        int[] inans= WriteAns.write_Ans(qus);
        PrintCalculation.print_Calculations(qus,inans);
    }
}
