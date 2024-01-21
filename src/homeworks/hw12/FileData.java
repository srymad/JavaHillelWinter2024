package homeworks.hw12;

public class FileData{
    private String name;
    private int capacity;
    private String path;

    public FileData(String name, int capacity, String path) {
        this.name = name;
        this.capacity = capacity;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return name;
    }


}
