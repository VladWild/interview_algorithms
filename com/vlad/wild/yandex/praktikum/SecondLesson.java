package vlad.wild.yandex.praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 *  Дан массив целых чисел arr и целое число X,
 *  нужно определить, существуют ли в массиве два элемента,
 *  сумма которых в точности равна X.
 */
public class SecondLesson {

    public static void main(String[] args) {
        int x = -7;
        int[] arr = new int[]{0, -2, 4, -4, -6, -11, 7};

        boolean func = func(arr, x);
        System.out.println(func);
    }

    public static boolean func(int[] arr, int x) {

        List<Boolean> booleans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i]; //число с которым мы проверяем все остальное
            for (int j = i + 1; j < arr.length; j++) {
                int sum = number + arr[j];
                if (sum == x) {
                    System.out.println("win: " + number + " + " + arr[j] + " = " + sum);
                    booleans.add(true);
                } else {
                    System.out.println(number + " + " + arr[j] + " = " + sum);
                }
                if (!booleans.isEmpty()) {
                    return true;
                }
            }
        }

        return false;
    }
}
