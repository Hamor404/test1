package generateEquations;

import static context.NUM.NUM;
import java.util.Random;

//此模块用于控制加减法
public class GenerateEquations {
    public static short[] generate_Equations() {
        short[] ov = new short[NUM];//用于记录符号
        int nums=0,add_nums=0;
        Random random = new Random();
        while(nums<NUM){
            ov[nums] = (short) random.nextInt(2);
            //控制加减法的数量各占一半
            if(ov[nums]==1){
                add_nums++;
            }
            if(add_nums>(NUM/2)){
                ov[nums]=0;
            }
            nums++;
        }

        return ov;
    }
    //用于测试
   public static void main(String[] args) {
        int add=0,sub=0;
        short[] ovtext=GenerateEquations.generate_Equations();
       for (int i = 0; i < NUM; i++) {
            if (ovtext[i]==1){
                add++;
            }else {
                sub++;
            }
       }
       System.out.println("生成加法"+add+"个"+",生成减法"+sub+"个");
    }
}