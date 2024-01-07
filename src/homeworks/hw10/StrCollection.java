package homeworks.hw10;

import java.util.Arrays;
import java.util.Objects;

public class StrCollection implements MyCollection{

    private String[] strings;
    private static final int startSize = 5;
    private int size;

    public StrCollection(){
        strings = new String[startSize];
        size = 0;
    }

    @Override
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

    @Override
    public boolean add(String value) {
        if(strings.length == size) enhanceSize();

        strings[size] = value;
        size++;

        return strings[size-1].equals(value);
    }

    @Override
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

    @Override
    public String get(int index) {
        if(index > strings.length || strings[index] == null) return "No string found with index %d".formatted(index);

        return strings[index];
    }

    @Override
    public boolean contain(String o) {
        for (String string : strings) {
            if (string.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean clear() {
        strings = new String[0];
        return true;
    }

    @Override
    public int size() {
        return strings.length;
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

    @Override
    public boolean equals(MyCollection myCollection) {
        if (this == myCollection) return true;
        if (myCollection == null || getClass() != myCollection.getClass()) return false;
        StrCollection that = (StrCollection) myCollection;
        return size == that.size && Arrays.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(strings), size);
    }


}
