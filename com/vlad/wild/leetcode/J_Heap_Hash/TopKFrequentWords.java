package vlad.wild.leetcode.J_Heap_Hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Топ K часто встречающихся слов
 *
 * Дан массив строк слов и целое число k, вернуть k наиболее частых строк.
 * Верните ответ, отсортированный по частоте от самой высокой к самой низкой.
 * Отсортируйте слова с одинаковой частотой по их лексикографическому порядку.
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] worlds = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;

        List<String> worldsSort = function(worlds, k);
        System.out.println(worldsSort);
    }

    public static List<String> function(String[] worlds, int k) {
        Map<String, Integer> worldCount = new HashMap<>();

        for (String world : worlds) {
            Integer valueCount = worldCount.get(world);
            if (valueCount == null) {
                worldCount.put(world, 1);
            } else {
                worldCount.put(world, ++valueCount);
            }
        }

        System.out.println(worldCount);

        Map<Integer, TreeSet<String>> sortMap = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> entry : worldCount.entrySet()) {
            TreeSet<String> stringsSort = sortMap.get(entry.getValue());
            if (stringsSort == null) {
                TreeSet<String> objects = new TreeSet<>(Comparator.naturalOrder());
                objects.add(entry.getKey());
                sortMap.put(entry.getValue(), objects);
            } else {
                stringsSort.add(entry.getKey());
            }
        }

        System.out.println(sortMap);

        List<String> objects = new ArrayList<>();

        Set<Map.Entry<Integer, TreeSet<String>>> entries = sortMap.entrySet();
        for (Map.Entry<Integer, TreeSet<String>> entry : entries) {
            objects.addAll(entry.getValue());
        }

        System.out.println(objects);

        List<String> list = objects.stream()
                .limit(k)
                .toList();

        return list;
    }

    public static List<String> function2(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Подсчёт частот
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Сортировка по убыванию частоты, затем по алфавиту
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(freqMap.entrySet());
        sorted.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            if (freqCompare == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return freqCompare;
        });

        // Сбор первых k слов
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(sorted.get(i).getKey());
        }

        return result;
    }
}
