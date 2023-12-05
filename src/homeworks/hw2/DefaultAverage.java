package homeworks.hw2;

public class DefaultAverage {
    public static void main(String[] args) {

        int size = Integer.parseInt(args[0]);
        double res = 0;

        for (int i = 0; i < size; i++) res += Double.parseDouble(args[i+1]);

        System.out.println(res/size);


    }
}
