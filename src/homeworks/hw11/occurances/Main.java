package homeworks.hw11.occurances;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Moe", "Alex", "Silvia", "Connor","Alex", "Silvia", "Connor",
                "Alex", "Silvia", "Connor", "Peter", "Carol", "Finn"));

        int[] array = new int[]{1,2,3,4,5,6,1,2,3,7,8,2,3,5,8,3};

        Occurances occurances = new Occurances();

        List<Integer> integerList = occurances.toList(array);

        System.out.println("Alex: " + occurances.countOccurance(list, "Alex"));
        System.out.println();

        System.out.println(occurances.toList(array));
        System.out.println();

        System.out.println(occurances.findUnique(integerList));
        System.out.println();

        occurances.calcOccurance(list);
        System.out.println();

        List<Object> objectList = occurances.findOccurance(list);
        for (int i = 0; i < objectList.size(); i++) {
            System.out.println("name: " + objectList.get(i) + ", occurance: " + objectList.get(++i));
        }

    }
}
