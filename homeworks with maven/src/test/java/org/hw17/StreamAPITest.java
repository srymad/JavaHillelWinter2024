package org.hw17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamAPITest {
    StreamAPI streamAPI = new StreamAPI();
    @Test
    void calculateAVG() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        assertEquals(6.5, streamAPI.calculateAVG(list));
    }

    @Test
    void fromLowerToUpperCase() {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");
        List<StreamAPI.Pair> pairList = streamAPI.fromLowerToUpperCase(list);

        for (int i = 0; i < list.size(); i++) {
            assertTrue(
                    pairList.get(i).getLowerCase()
                    .equals(list.get(i)) &&
                    pairList.get(i).getUpperCase()
                    .equals(list.get(i).toUpperCase())
            );
        }

    }

    @Test
    void printByFilters() {
        List<String> list = Arrays.asList("one", "TWO", "nine", "three", "FOUR", "five");
        List<String> resList = streamAPI.printByFilters(list);

        resList.forEach(s ->{
            assertTrue(s.equals(s.toLowerCase()) && s.length() == 4);
        });
    }
}