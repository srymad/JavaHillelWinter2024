package homeworks.hw11.occurances;

import java.util.*;

public class Occurances {
    public int countOccurance(List<String> list, String str){
        int count = 0;

        for (String element:list) {
            if(element.equals(str)) count++;
        }

        return count;
    }

    public List<Integer> toList(int[] array){
        List<Integer> list = new ArrayList<>();

        for (int element:array) {
            list.add(element);
        }

        return list;
    }

    public List<Integer> findUnique(List<Integer> list){
        HashSet<Integer> hashSet = new HashSet<>(list);

        return new ArrayList<>(hashSet);
    }


    public void calcOccurance(List<String> list){
        List<String> newList = new ArrayList<>();
        int[] counter = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            if(newList.contains(list.get(i))){
                counter[newList.indexOf(list.get(i))]++;
            }else{
                newList.add(list.get(i));
                counter[newList.indexOf(list.get(i))]++;
            }
        }

        int i = 0;
        while(counter[i]!=0){
            System.out.println(newList.get(i) + ": " + counter[i]);
            i++;
        }

    }

    public List<Object> findOccurance(List<String> list){
        List<Object> objectsList = new ArrayList<>();

        List<String> newList = new ArrayList<>();
        int[] counter = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            if(newList.contains(list.get(i))){
                counter[newList.indexOf(list.get(i))]++;
            }else{
                newList.add(list.get(i));
                counter[newList.indexOf(list.get(i))]++;
            }
        }

        for (int i = 0; counter[i] != 0; i++) {
            objectsList.add(newList.get(i));
            objectsList.add(counter[i]);
        }

        return objectsList;
    }
}
