package generateEquations;

import static context.NUM.NUM;
import java.util.Random;

public class GenerateEquations {
    public static short[] generate_Equations() {
        short[] ov = new short[NUM];
        int nums=0,add_nums=0;
        Random random = new Random();
        while(nums<NUM){
            ov[nums] = (short) random.nextInt(2);
            if(ov[nums]==1){
                add_nums++;
            }
            if(add_nums>25){
                ov[nums]=0;
            }
            nums++;
        }
        for (int i = 0; i < NUM; i++) {

            ov[i] = (short) random.nextInt(2);
        }
        return ov;
    }
}