package homeworks.hw7.task0;

public class Triangle implements Squarable{
    private double sideOne;
    private double sideTwo;
    private double sideThree;

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }


    @Override
    public double squareCalculate() {
        double pH = (sideOne + sideTwo + sideThree) / 2; // half of perimeter
        double square = Math.sqrt(pH * ((pH-sideOne) * (pH-sideTwo) * (pH-sideThree)));
        return square;
    }
}
