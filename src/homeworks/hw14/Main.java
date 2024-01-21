package homeworks.hw14;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayValueCalculator calculator = new ArrayValueCalculator();

        // Array for ArraySizeException
        String[][] arrayWithSizeException = new String[4][5];

        try {
            System.out.println("Result is " + calculator.doCalc(arrayWithSizeException));
        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();


        // Array for ArrayDataException
        String[][] arrayWithDataException = new String[4][4];
        try {
            System.out.println("Result is " + calculator.doCalc(arrayWithDataException));
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();


        // Valid array
        String[][] array = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = String.valueOf(random.nextInt(100));
            }
        }

        System.out.println(Arrays.deepToString(array));

        try {
            System.out.println("Result is " + calculator.doCalc(array));
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

    }
}
