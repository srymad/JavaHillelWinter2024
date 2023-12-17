package homeworks.hw7.task0;

public class Quadrate implements Squarable{
    private double side;

    public Quadrate(double side) {
        this.side = side;
    }

    @Override
    public double squareCalculate() {
        return side * side;
    }
}
