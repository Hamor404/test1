package printCalculations;

import static context.NUM.NUM;

//此模块用来输出答案判断对错
public class PrintCalculation {
    public static void print_Calculations(short[][] qus,int[] inans){
        int[] ans=new int[NUM];//用来存储答案
        int i,j=0;
        //计算答案
        for (i = 0; i < NUM; i++) {
            if(qus[i][1]==1){
                ans[i]= qus[i][0]+ qus[i][2];
            }else {
                ans[i]= qus[i][0]- qus[i][2];
            }
        }
        //判断对错
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
        //打印答案
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
    //用于测试
    public static void main(String[] args) {
        short[][] qustext={{1,0,1}};
        int[] inanstest={1};
        NUM=qustext.length;
        PrintCalculation.print_Calculations(qustext,inanstest);
    }
}

