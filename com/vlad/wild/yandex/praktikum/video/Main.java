package vlad.wild.yandex.praktikum.video;

/**
 * Дан вектор из чисел N
 * Найти наибольшую последовательность единиц
 */
public class Main {

    public static void main(String[] args) {
        int[] ints = {};

        int func = func(ints);
        System.out.println(func);
    }

    public static int func(int [] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int best = 0;
        int current = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ++current;
            } else {
                best = Math.max(best, current);
                current = 0;
            }
        }

        best = Math.max(best, current);

        return best;
    }
}
