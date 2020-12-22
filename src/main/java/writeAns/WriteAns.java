package writeAns;

import static context.NUM.NUM;
import java.util.Scanner;

//此模块用于记录用户输入的答案
public class WriteAns {
    public static int[] write_Ans(int[] inans,int n){
        int i=0,y=n,x=0;
        System.out.println("请输入答案：(输入'-1'退出)");
        if (n==0){
            System.out.println("第1套题答案");
        }else {
            System.out.println("请填入第"+((n+1)/NUM+1)+"套第"+((n+1)%NUM)+"题答案");
        }
            for (i=n; i < 3*NUM; i++) {
                Scanner in = new Scanner(System.in);
                x=in.nextInt();
                if(x==-1){break;}
                inans[i] = x;
                y++;
                if (y % NUM == 0) {
                    System.out.println("第" + (y / NUM + 1) + "套题答案");

                }
            }

        return inans;
    }
}
