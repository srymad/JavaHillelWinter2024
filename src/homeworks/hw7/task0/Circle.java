package homeworks.hw7.task0;


public class Circle implements Squarable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double squareCalculate() {
        return Math.PI * Math.pow(radius, 2);
    }
}
