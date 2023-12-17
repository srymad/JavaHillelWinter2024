package homeworks.hw7.task1to7;

public class Obstacle {
    private int length;
    public Obstacle(int length){
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + length;
    }
}
