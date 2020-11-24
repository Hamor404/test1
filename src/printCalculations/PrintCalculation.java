package printCalculations;

import static context.NUM.NUM;

public class PrintCalculation {
    public static void print_Calculations(short[][] qus,int[] inans){
        int[] ans=new int[NUM];
        int i,j=0;

        for (i = 0; i < NUM; i++) {
            if(qus[i][1]==1){
                ans[i]= qus[i][0]+ qus[i][2];
            }else {
                ans[i]= qus[i][0]- qus[i][2];
            }
        }
        for (i = 0; i < NUM; i++) {
            if(inans[i]==ans[i]){
                System.out.print(""+"正确"+"\t\t");
            }
            if(inans[i]!=ans[i]){
                System.out.print(""+"错误"+"\t\t");
            }
            j++;
            if (j%4==0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("下面是习题的参考答案:");
        j=0;
        for (i = 0; i <NUM; i++) {
            System.out.print(""+(i+1)+":"+ ans[i]+"\t");
            j++;
            if (j%4==0){
                System.out.println();
            }
        }
    }
}
