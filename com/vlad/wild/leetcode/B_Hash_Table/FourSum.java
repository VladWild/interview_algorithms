package vlad.wild.leetcode.B_Hash_Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Если дан массив nums из n целых чисел, верните массивы из 4-ех чисел [nums[a], nums[b], nums[c], nums[d]] такой, что:
 * 0 <= a, b, c, d < n
 * a, b, c, d являются различными.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * Вы можете вернуть ответ в любом порядке.
 */
public class FourSum {

    public static void main(String[] args) {
        int nums[] = {1, 0, -1, 0, -2, 2}; // -2 -1 0 0 1 2
        int target = 0;

        List<List<Integer>> lists = fourSum2(nums, target);
        System.out.println(lists);
    }

    //оптимальное решение O(n³)
    public static List<List<Integer>> fourSum2(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // пропуск дубликатов i

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // пропуск дубликатов j

                int sum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum2 = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum2 == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum2 < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    //не оптимально O(n⁴)
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Set<Set<Integer>> sets = new HashSet<>();

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        Set<Integer> set = new HashSet<>(list);
                        if (!sets.contains(set) && sum == target) {
                            lists.add(new ArrayList<>(list));
                        }
                        sets.add(set);
                    }
                }
            }
        }

        return lists;
    }
}
