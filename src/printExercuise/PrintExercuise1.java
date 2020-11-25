package printExercuise;

import static context.NUM.NUM;
import java.util.Random;

//此模块用于打印题目
public class PrintExercuise {
    public static short[][] print_Exercuise(short[] ov){
        char[] o=new char[NUM];//用于存储符号
        short m;//m是第一个操作数
        short n;//n是第二个操作数
        short[][] qus=new short[NUM][3];//用于存储生成的算式
        int nums=0,res;
        Random random=new Random();
        while (nums<NUM) {
                m = (short) random.nextInt(101);
                n = (short) random.nextInt(101);
                if(ov[nums]==1){
                    res=m+n;
                    o[nums]='+';
                }else {
                    res=m-n;
                    o[nums]='-';
                }
                //用于确保算式的答案在0~100以内
                if(res>=0&&res<=100){
                    qus[nums][0] = m;
                    qus[nums][1] = ov[nums];
                    qus[nums][2] = n;
                    nums++;
                    }
                //用于确保没有重复的算式
                if(nums!=1){
                    for(int i=0;i<nums-1;i++){
                        if(qus[i]==qus[nums-1]){
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
            System.out.print("" + (i + 1) + ":\t" + qus[i][0] + o[i] + qus[i][2] + "=\t");
            j++;

        }
        System.out.println();
        return qus;
        }

    //用于测试
    public static void main(String[] args){
        short[] ovtext={0,1,0,1,0,0,1,1};
        NUM=ovtext.length;
        PrintExercuise.print_Exercuise(ovtext);

    }
}


