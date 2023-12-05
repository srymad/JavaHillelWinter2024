package homeworks.hw2;

public class DepositCalculator {
    public static void main(String[] args) {

        double amount = Double.parseDouble(args[0]);
        double interestRate = (Double.parseDouble(args[1]) / 100); // Переведення у відсотки
        int term = Integer.parseInt(args[2]);

        for (int i = 1; i <= term; i++) {
            double starterAmount = amount; // Сума грошей на початку року
            for (int j = 1; j <= 12; j++) amount += amount * interestRate/12;
            System.out.printf("Рік #%d: %.2f грн. Нараховані відсотки за рік: %.2f грн\n", i, amount, amount - starterAmount);
        }
    }
}
