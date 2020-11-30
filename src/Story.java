
import static context.NUM.NUM;

import equation.AdditionEquations;
import equation.Equation;
import exercise.Exercise;
import printHeader.PrintHeader;
import writeAns.WriteAns;


//主函数
public class Story {
    public static void main(String[] args){
        int select;
        Exercise exercise=new Exercise();
        Equation[] equation=new AdditionEquations[NUM];
        select=PrintHeader.print_Header();
        switch (select){
            case 1:equation=exercise.gernAddequation(NUM);
            break;
            case 2:equation=exercise.gernSubequation(NUM);
            break;
            case 3:equation=exercise.gernequatExercise(NUM);
            break;
        }
        exercise.print_Exercuise(equation);
        int[] inans= WriteAns.write_Ans();
        exercise.print_Calculations(equation,inans);
    }
}
