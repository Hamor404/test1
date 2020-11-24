package printExercuise;

import static context.NUM.NUM;
import java.util.Random;

public class PrintExercuise {
    public static short[][] print_Exercuise(short[] ov){
        char[] o=new char[NUM];
        short m;
        short n;
        short[][] qus=new short[NUM][3];
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
                if(res>=0&&res<=100){
                    qus[nums][0] = m;
                    qus[nums][1] = ov[nums];
                    qus[nums][2] = n;
                    nums++;
                    }
                if(nums!=1){
                    for(int i=0;i<nums-1;i++){
                        if(qus[i]==qus[nums-1]){
                            nums--;
                            break;
                        }
                    }
                }


        }
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
    }

