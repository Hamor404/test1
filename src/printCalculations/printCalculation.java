package printCalculations;

public class printCalculation {
    public static void print_Calculations(short[][] qus){
        int[] ans=new int[50];
        int i,j=0;
        System.out.println("下面是习题的参考答案:");
        for (i = 0; i < 50; i++) {
            if(qus[i][1]==1){
                ans[i]= qus[i][0]+ qus[i][2];
            }else {
                ans[i]= qus[i][0]- qus[i][2];
            }
        }
        for (i = 0; i < 50; i++) {
            System.out.print(""+(i+1)+":\t"+ ans[i]+"\t");
            j++;
            if (j%4==0){
                System.out.println();
            }
        }
    }
}
