package printExercuise;

import java.util.Random;

public class printExercuise {
    public static short[][] print_Exercuise(short[] ov){
        char[] o=new char[50];
        short m;
        short n;
        short[][] qus=new short[50][3];
        int i=0,j=0,res;
        Random random=new Random();
        while (i<50) {
                m = (short) random.nextInt(101);
                n = (short) random.nextInt(101);
                if(ov[i]==1){
                    res=m+n;
                    o[i]='+';
                }else {
                    res=m-n;
                    o[i]='-';
                }
                if(res>=0&&res<=100){
                    qus[i][0] = m;
                    qus[i][1] = ov[i];
                    qus[i][2] = n;
                    i++;
                    }
                }
        for (i=0;i<50;i++){
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

