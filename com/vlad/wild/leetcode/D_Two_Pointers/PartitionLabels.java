package vlad.wild.leetcode.D_Two_Pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Вам дается строка s.
 * Мы хотим разбить строку на как можно большее количество частей, чтобы каждая буква появлялась не более чем в одной части.
 * Например, строка 'ababcc' может быть разделена на ['abab', 'cc'], но такие разделы, как ['aba', 'bcc'] или ['ab', 'ab', 'cc'], являются недействительными.
 *
 * Обратите внимание, что секционирование сделано для того, чтобы после конкатенации всех частей по порядку, результирующая строка должна быть s.
 *
 * Return список целых чисел, представляющих размер этих частей.
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij"; // "ababcbaca", "defegde", "hijhklij"

        List<Integer> integers = partitionLabels2(s);
        System.out.println(integers);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> integers = new ArrayList<>();

        int left = 0;
        int leftSecond = left + 1;

        while (left < s.length()) {
            char leftChar = s.charAt(left);

            for (int i = left; i < s.length(); i++) {
                if (s.charAt(i) == leftChar) {
                    leftSecond = Math.max(leftSecond, i);
                }
            }

            ++left;

            if (left == leftSecond) {
                int result;
                if (integers.isEmpty()) {
                    result = left + 1;
                } else {
                    result = (left + 1) - integers.stream().reduce(Integer::sum).get();
                }
                integers.add(result);
            }
        }

        return integers;
    }

    public static List<Integer> partitionLabels2(String s) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26]; //количество символов в алфавите

        // Запомним последнее вхождение каждой буквы
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
