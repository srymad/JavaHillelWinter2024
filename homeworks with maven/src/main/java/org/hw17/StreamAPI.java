package org.hw17;

import java.util.Collection;
import java.util.List;

public class StreamAPI {
    public double calculateAVG(Collection<Integer> collection){
        double sum = collection.stream()
                .mapToInt(Integer::intValue).sum();

        double count = collection.stream()
                .count();

        return sum/count;
    }

    public List<Pair> fromLowerToUpperCase(Collection<String> collection){
        return collection.stream()
                .map(s -> new Pair(s, s.toUpperCase()))
                .toList();
    }

    public List<String> printByFilters(Collection<String> collection){
        List<String> list;

         list = collection.stream()
                .filter(s -> s.equals(s.toLowerCase()) && s.length() == 4)
                 .toList();

         list.stream().forEach(System.out::println);

         return list;
    }

    static class Pair{
        private String lowerCase;
        private String upperCase;

        public Pair(String lowerCase, String upperCase) {
            this.lowerCase = lowerCase;
            this.upperCase = upperCase;
        }

        public String getLowerCase() {
            return lowerCase;
        }

        public String getUpperCase() {
            return upperCase;
        }
    }
}
