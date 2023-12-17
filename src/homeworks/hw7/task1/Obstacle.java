package homeworks.hw7.task1;

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
