package test;

import equation.AdditionEquations;
import equation.Equation;
import equation.SubstractEquations;
import exercise.Exercise;
import csvfile.CsvFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;


public class Test1 {
    private static final int N = 100;
    @Test
    public void Addequatest(){
        Exercise exercise=new Exercise();
        Equation[] equation=new AdditionEquations[N];
        equation=exercise.gernAddequation(N);
        for (Equation i:equation) {
            Assertions.assertSame(i.getOperator(),(short)1);
        }

    }
    @Test
    public void Subequatest(){
        Exercise exercise=new Exercise();
        Equation[] equation=new SubstractEquations[N];
        equation=exercise.gernSubequation(N);
        for (Equation i:equation) {
            Assertions.assertSame(i.getOperator(),(short)0);
        }
    }
    @Test
    public void checkRepeatedEquation() {
        Exercise exercise=new Exercise();
        Equation[] equation=new AdditionEquations[N];
        equation=exercise.gernequatExercise(N);
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                Assertions.assertNotSame(equation[i],equation[j]);
            }
        }
    }
    @Test
    public void checkNumber(){
        Exercise exercise=new Exercise();
        Equation[] equation=new AdditionEquations[N];
        equation=exercise.gernequatExercise(N);
        for (Equation i :equation) {
            Assertions.assertTrue(0 <= i.getFirst() && i.getFirst() <= 100);
            Assertions.assertTrue(0 <= i.getSecond() && i.getSecond() <= 100);
        }
    }
    @Test
    public void checkAnswer(){
        Exercise exercise=new Exercise();
        Equation[] equation=new AdditionEquations[N];
        equation=exercise.gernequatExercise(N);
        for (Equation i :equation) {
            Assertions.assertTrue(0 <= i.getAnswer() && i.getAnswer() <= 100);
        }
    }

    @Test
    public void maintext(){
        Exercise exercise=new Exercise();
        Equation[] equation=new AdditionEquations[N];
        equation=exercise.gernequatExercise(N);
        exercise.print_Exercuise(equation,0);
    }


}
