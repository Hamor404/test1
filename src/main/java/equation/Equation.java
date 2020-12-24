package equation;

import java.util.Random;

//此模块定义了等式类
public  abstract class Equation {
    private short first;
    private short operator;
    private short second;
    private int answer;
    //默认构造方法
    public Equation(){
        this.first=1;
        this.operator=1;
        this.second=1;
        this.answer=2;
    }
    //自定义构造方法
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

    public void gernEquat(short oper){
        Random random = new Random();
        this.setOperator(oper);
        this.setFirst((short) random.nextInt(101));
        this.setSecond((short) random.nextInt(101));
    }
    public int Calculation(){
        System.out.println("calculation answer");
        return 0;
    }
    public boolean ChkAnswer(int ans){
        return this.getAnswer() == ans;
    }
    @Override
    public String toString(){
        if (operator==1){
            return first+"+"+second+"=";
        }else{
            return first+"-"+second+"=";
        }
    }


}

