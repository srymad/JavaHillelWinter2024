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
        if(strings.length == size) enhanceSize();

        if(index > strings.length-1) {
            System.out.printf("Max index in the array is %d\n", size-1);
            return false;
        }

        String[] tempString = new String[strings.length];

        for (int i = 0, j = 0; i < strings.length; i++) {
            if(i == index){
                tempString[i] = value;
                continue;
            }
            tempString[i] = strings[j];
            j++;
        }

        strings = tempString;
        size++;

        return strings[index].equals(value);
    }

    public boolean add(String value) {
        if(strings.length == size) enhanceSize();

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

        size--;
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

        size--;
        strings = tempString;

        return true;
    }

    public String get(int index) {
        if(index > strings.length || strings[index] == null) return "No string found with index %d".formatted(index);

        return strings[index];
    }

    private void enhanceSize(){
        int newSize = strings.length + 1;
        strings =  Arrays.copyOf(strings, newSize);
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}
