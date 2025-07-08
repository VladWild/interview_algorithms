package vlad.wild.leetcode.C_Sort;

import java.util.Arrays;

/**
 * Selection Sort (сортировка выбором)
 */
public class SortInner {

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 3, -1, 0, 9};
        int[] arr1 = sort(arr);
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int left = arr[i];
                int right = arr[j];
                if (left > right) {
                    int small = right;
                    arr[j] = left;
                    arr[i] = small;
                }
            }
        }


        return arr;
    }
}
