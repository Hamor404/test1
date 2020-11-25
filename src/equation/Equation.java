package equation;

public class Equation {
    private short first;
    private short operator;
    private short second;
    private int answer;
    public Equation(){
        this.first=1;
        this.operator=1;
        this.second=1;
        this.answer=2;
    }
    public Equation(short f,short o,short s,int a){
        this.first=f;
        this.operator=o;
        this.second=s;
        this.answer=a;
    }


    public short getFirst(){
        return first;
    }
    public void setFirst(short first){
        this.first=first;
    }
    public short getOperator(){
        return operator;
    }
    public void setOperator(short operator){
        this.operator=operator;
    }
    public short getSecond(){
        return second;
    }
    public void setSecond(short second){
        this.second=second;
    }
    public int getAnswer(){
        return answer;
    }
    public void setAnswer(int answer){
        this.answer=answer;
    }
    @Override
    public String toString(){
        if (operator==1){
            return first+" + "+second+" = ";
        }else{
            return first+" - "+second+" = ";
        }
    }
}
