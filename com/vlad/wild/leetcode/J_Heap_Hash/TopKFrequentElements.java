package vlad.wild.leetcode.J_Heap_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Дан целочисленный массив nums и целое число k, вернуть k наиболее частых элементов.
 * Вы можете вернуть ответ в любом порядке.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 2, 3};
        int k = 2;

        int[] func = func(ints, 2);
        System.out.println(Arrays.toString(func));
    }

    public static int[] func(int[] ints, int k) {
        Map<Integer, Integer> elemCount = new TreeMap<>();

        for (int i = 0; i < ints.length; i++) {
            elemCount.put(ints[i], elemCount.getOrDefault(ints[i], 0) + 1);
        }

        System.out.println(elemCount);

        Map<Integer, List<Integer>> integerIntegerTreeMap = new TreeMap<>(Comparator.reverseOrder());

        Set<Map.Entry<Integer, Integer>> entries = elemCount.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            List<Integer> integers = integerIntegerTreeMap.get(entry.getValue());
            if (integers == null) {
                List<Integer> objects = new ArrayList<>();
                objects.add(entry.getKey());
                integerIntegerTreeMap.put(entry.getValue(), objects);
            } else {
                integers.add(entry.getKey());
            }
        }

        System.out.println(integerIntegerTreeMap);

        int[] array = integerIntegerTreeMap.entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream())
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();

        return array;
    }
}
