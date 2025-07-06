package vlad.wild.leetcode.B_Hash_Table;

import java.util.HashMap;
import java.util.Map;

/**
 * Если дан непустой массив целых чисел nums, каждый элемент появляется дважды, кроме одного. Найдите тот самый.
 * Необходимо реализовать решение с линейной сложностью времени выполнения и использовать только постоянное дополнительное пространство.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int nums[] = {4,1,2,1,2};

        int i = singleNumber(nums);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> numberCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            Integer count = numberCount.get(elem);
            if (count == null) {
                numberCount.put(elem, 1);
            } else {
                numberCount.put(elem, count + 1);
            }
        }

        System.out.println(numberCount);

        Integer i = numberCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        return i;
    }

    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
