package ims;

import java.util.Random;

public class Test1 {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);
        for (int j = 0; j < 10; j++) {
            System.out.println(String.format("%02d",i));

        }
    }
}
