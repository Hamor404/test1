package generateEquations;

import java.util.Random;

public class generateEquations {
    public static short[] generate_Equations() {
        short[] ov = new short[50];
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            ov[i] = (short) random.nextInt(2);
        }
        return ov;
    }
}