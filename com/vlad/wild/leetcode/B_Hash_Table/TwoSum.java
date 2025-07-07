package vlad.wild.leetcode.B_Hash_Table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Если дан массив целых чисел nums и целочисленный target, возвращаются индексы двух чисел так, что их сумма равна цели.
 * Можно предположить, что каждый вход будет иметь ровно одно решение, и нельзя использовать один и тот же элемент дважды.
 * Вы можете вернуть ответ в любом порядке.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int target = 9;

        int[] ints1 = twoSum2(ints, target);
        System.out.println(Arrays.toString(ints1));
    }

    //оптимальное решение через мапу
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int elem = target - nums[i];
            if (map.containsKey(elem)) {
                return new int[]{map.get(elem), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


    //не оптимальное решение
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] ints = {i, j};
                    return ints;
                }
            }
        }

        return null;
    }
}
