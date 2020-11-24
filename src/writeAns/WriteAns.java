package writeAns;

import static context.NUM.NUM;
import java.util.Scanner;

//此模块用于记录用户输入的答案
public class WriteAns {
    public static int[] write_Ans(short[][] qus){
        int[] inans=new int[NUM];
        System.out.println("请输入答案：");
        for (int i = 0; i < NUM; i++) {
            Scanner in=new Scanner(System.in);
            inans[i]=in.nextInt();
        }
        return inans;
    }
}
