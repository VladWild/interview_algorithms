package vlad.wild.yandex.praktikum.chapter3.lesson10;

import java.util.Arrays;

/**
 * Написать функцию, которая принимает на вход 3 целых числа и возвращает их медиану.
 * Встроенной функцией сортировки пользоваться нельзя!!!!!!!
 */
public class MainLesson10 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 7};

        var avr = function(arr);
        System.out.println(avr);
    }

    public static int function(int[] arr) {
        int[] sortArr = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                sortArr[j + 1] = arr[j];
                j--;
            }

            sortArr[j + 1] = key;
        }

        System.out.println(Arrays.toString(sortArr));

        return sortArr[arr.length / 2];
    }
}
