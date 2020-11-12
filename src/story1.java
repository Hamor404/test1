
import java.util.Random;
public class story1 {
    public static short[] m=new short[50];
    public static short[] n=new short[50];
    public static short[] ov=new short[50];
    public static int[] ans=new int[50];
    public static void main(String[] args){
        printHeader();
        generateEquations();
        printExercuise();
        System.out.println("下面是习题的参考答案");
        printCalculations();
    }


    public static void printHeader(){
        System.out.println("加减法口算练习系统-v0.1");
        System.out.println("程序将输出50道100以内的加减法算式习题");
        System.out.println("每次运行程序可得到一套50道题的习题及答案");
    }
    public static void generateEquations(){
        Random random=new Random();
        for (int i = 0; i < 50; i++) {
            ov[i]=(short) random.nextInt(2);
        }

    }
    public static void printExercuise(){
        char o;
        Random random=new Random();
        for (int i = 0; i < 50; i++) {
            m[i]=(short) random.nextInt(101);
            n[i]=(short) random.nextInt(101);
            if(ov[i]==1){
                o='+';
            }else {
                o='-';
            }
            System.out.println(""+(i+1)+":\t"+ m[i]+o+ n[i]+"=");
        }
    }
    public static void printCalculations(){
        for (int i = 0; i < 50; i++) {
            if(ov[i]==1){
                ans[i]= m[i]+ n[i];
            }else {
                ans[i]= m[i]- n[i];
            }
            System.out.println(""+(i+1)+":\t"+ ans[i]);
        }
    }
}
