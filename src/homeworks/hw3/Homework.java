package homeworks.hw3;

import java.util.Arrays;
import java.util.Random;

public class Homework {
    Random random = new Random();

    public void taskOne() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) System.out.print(i + " ");
        }
    }

    public int taskTwo(int n) {
        int res = 1;

        for (int i = n; i > 1; i--) {
            res *= i;
        }

        return res;
    }

    public void taskThree_One() {
        int i = 1;
        while (i < 100) {
            if (i % 2 != 0) System.out.print(i + " ");
            i++;
        }
        System.out.println();
    }

    public int taskThree_Two(int n) {
        int res = 1;
        int i = n;
        while (i > 1) {
            res *= i;
            i--;
        }

        return res;
    }

    public void taskFour_One() {
        int i = 1;
         do{
            if (i % 2 != 0) System.out.print(i + " ");
            i++;
        }while (i < 100);
        System.out.println();
    }

    public int taskFour_Two(int n) {
        int res = 1;
        int i = n;
         do{
            res *= i;
            i--;
        }while (i > 1);

        return res;
    }

    public int taskFive(int x, int n) {
        int res = x;
        for (int i = 1; i < n; i++) {
            res *= x;
        }

        return res;
    }

    public void taskSix() {
        int i = 0;
        int j = 0;
        while (i != 10) {
            System.out.print(j + " ");
            j += -5;
            i++;
        }
    }

    public void taskSeven(int x) {
        for (int i = 2; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", x, i, x * i);
        }
    }

    public void taskEight() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100);
            if (x % 2 != 0) arr[i] = x;
            else {
                x++;
                arr[i] = x;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public int taskNine(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int x = random.nextInt(100);
            arr[i] = x;
        }

        int min = arr[0];

        for (int i: arr) {
            if(i < min) min = i;
        }
        return min;
    }

    public int taskTen(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int x = random.nextInt(100);
            arr[i] = x;
        }

        int max = arr[0];

        for (int i: arr) {
            if(i > max) max = i;
        }
        return max;
    }


    public void taskEleven(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int x = random.nextInt(100);
            arr[i] = x;
        }

        System.out.println(Arrays.toString(arr));

        int max = arr[0];
        int min = arr[0];

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < size; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if(arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        arr[maxIndex] = min;
        arr[minIndex] = max;

        System.out.println(Arrays.toString(arr));

    }
}