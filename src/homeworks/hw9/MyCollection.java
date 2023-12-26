package homeworks.hw9;

import java.util.Arrays;

public class MyCollection {
    private String[] strings;
    private static final int startSize = 5;
    private int size;

    public MyCollection(){
        strings = new String[startSize];
        size = 0;
    }
    public boolean add(int index, String value) {
        if(strings.length == size || strings.length - 1 == size) enhanceSize();

        if(strings[index] != null){
            System.out.printf("Index %d is not empty\n", index);
            return false;
        }

        strings[index] = value;
        size++;

        return strings[index].equals(value);
    }

    public boolean add(String value) {
        if(strings.length == size || strings.length - 1 == size) enhanceSize();

        strings[size] = value;
        size++;

        return strings[size-1].equals(value);
    }

    public boolean delete(int index) {
        if(index > strings.length - 1){
            System.out.println("No string found with index " + index);
            return false;
        }

        String[] tempString = new String[strings.length];
        for (int i = 0, j = 0; i < strings.length; i++) {
            if(i == index)continue;
            tempString[j] = strings[i];
            j++;
        }

        strings = tempString;

        return true;
    }

    public boolean delete(String value) {
        boolean flag = false; //перевірка на існування рядка в масиві
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(value)) {
                flag = true;
                index = i;
                break;
            }
        }
        if(!flag){
            System.out.println("No string found");
            return false;
        }

        String[] tempString = new String[strings.length];
        for (int i = 0, j = 0; i < strings.length; i++) {
            if(i == index)continue;
            tempString[j] = strings[i];
            j++;
        }

        strings = tempString;

        return true;
    }

    public String get(int index) {
        if(index > strings.length || strings[index] == null) return "No string found with index %d".formatted(index);

        return strings[index];
    }

    private void enhanceSize(){
        int newSize = strings.length + 5;
        strings =  Arrays.copyOf(strings, newSize);
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}
