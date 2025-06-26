package vlad.wild.yandex.praktikum.chapter3.lesson2;

import java.util.Arrays;

/**
 * Метод двух указателей!
 * Дан массив целых отсортированный чисел arr в порядке возрастания и целое число X.
 * Определите, существует ли в массиве такой непрерывный подмассив, что сумма его элементов равна X.
 */
public class TwoPointers2 {

    public static void main(String[] args) {
        int[] sort_array = {-1, 1, 2, 4, 5, 6};
        int x = 9;

        boolean result = function(sort_array, x);
        System.out.println(result);
    }

    public static boolean function(int[] sort_array, int x) {
        int right = 0;
        int sum = 0;

        for (int left = 0; left < sort_array.length; left++) {
            if (left > 0) {
                sum -= sort_array[left - 1];
            }

            while (right < sort_array.length && sum < x) {
                sum += sort_array[right];
                right++;
            }

            if (sum == x) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(sort_array, left, right)));
                return true;
            }
        }

        return false;
    }
}
