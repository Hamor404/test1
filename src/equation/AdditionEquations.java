package equation;

public class AdditionEquations extends Equation{
    @Override
    public int Calculation(){
       return this.getFirst()+this.getSecond();
    }

}
