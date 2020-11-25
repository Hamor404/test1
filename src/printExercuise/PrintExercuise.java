package printExercuise;

import equation.Equation;

import static context.NUM.NUM;
import java.util.Random;
import java.util.Scanner;

//此模块用于打印题目
public class PrintExercuise {
    public static Equation[] print_Exercuise(Equation[] equations){
        char[] o=new char[NUM];//用于存储符号
        short m;//m是第一个操作数
        short n;//n是第二个操作数
        int nums=0,res;
        Random random=new Random();
        while (nums<NUM) {
                m = (short) random.nextInt(101);
                n = (short) random.nextInt(101);
                if(equations[nums].getOperator()==1){
                    res=m+n;
                    o[nums]='+';
                }else {
                    res=m-n;
                    o[nums]='-';
                }
                //用于确保算式的答案在0~100以内
                if(res>=0&&res<=100){
                    equations[nums].setFirst(m);
                    equations[nums].setSecond(n);
                    nums++;
                    }
                //用于确保没有重复的算式
                if(nums!=1){
                    for(int i=0;i<nums-1;i++){
                        if(equations[i]==equations[nums-1]){
                            nums--;
                            break;
                        }
                    }
                }


        }
        //打印算式
        int j=0;
        for (int i=0;i< NUM;i++ ){
            if(j%4==0) {
                System.out.println();
            }
            System.out.print("" + (i + 1) + ":\t" + equations[i].getFirst() + o[i] + equations[i].getSecond() + "=\t");
            j++;

        }
        System.out.println();
        return equations;
        }

    //用于测试
    public static void main(String[] args){
        System.out.println("请输入算式的数量：");
        Scanner in=new Scanner(System.in);
        NUM=in.nextInt();
        Equation[] equationtest=new Equation[NUM];
        for (int i = 0; i < NUM; i++) {
            equationtest[i]= new Equation();
        }
        equationtest[0]=new Equation((short) 0,(short) 0,(short) 0,0);
        equationtest[1]=new Equation((short) 0,(short) 1,(short) 0,0);
        PrintExercuise.print_Exercuise(equationtest);

    }
}


