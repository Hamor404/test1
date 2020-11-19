
import generateEquations.generateEquations;
import printHeader.printHeader;
import printExercuise.printExercuise;
import printCalculations.printCalculation;

public class story1 {
    public static void main(String[] args){
        printHeader.print_Header();
        short[] ov = generateEquations.generate_Equations();
        short[][] qus=printExercuise.print_Exercuise(ov);
        printCalculation.print_Calculations(qus);
    }


}
