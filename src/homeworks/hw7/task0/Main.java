package homeworks.hw7.task0;

public class Main {
    public static void main(String[] args) {
        Quadrate quadrate = new Quadrate(10);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(5, 4, 3);

        Squarable[] squarables = new Squarable[]{quadrate, circle, triangle};

        System.out.printf("Square of %s: %.2f\n", squarables[0].getClass().getSimpleName(), squarables[0].squareCalculate());
        System.out.printf("Square of %s: %.2f\n", squarables[1].getClass().getSimpleName(), squarables[1].squareCalculate());
        System.out.printf("Square of %s: %.2f\n\n", squarables[2].getClass().getSimpleName(), squarables[2].squareCalculate());

        calculateSquaresOfArray(squarables);
    }

    public static void calculateSquaresOfArray(Squarable[] squarable){
        double res = 0;
        for (Squarable element: squarable) {
            res += element.squareCalculate();
        }
        System.out.printf("Sum of all squares: %.2f", res);
    }

}
