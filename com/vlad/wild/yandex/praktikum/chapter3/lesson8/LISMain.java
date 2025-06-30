package vlad.wild.yandex.praktikum.chapter3.lesson8;

/**
 * Дан массив из N целых чисел arr. Найдите длину максимальной возрастающей подпоследовательности в этом массиве.
 * Например, при arr=[2, 3, 6, 4, 1, 3, 5, 4, 7] искомая подпоследовательность — [2, 3, 4, 5, 7] и поэтому ответ равен 5.
 */
public class LISMain {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        System.out.println("Length of LIS: " + longestIncreasingSubsequence(arr)); // 4
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        if (arr.length == 0) return 0;

        int[] dp = new int[arr.length];
        // Изначально длина возрастающей подпоследовательности на каждом индексе — 1
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println("i=" + i + ", arr[i]=" + arr[i] + ", j=" + j +", arr[j]=" + arr[j] + "  -> dp[i]=" + dp[i]);
                }
            }
        }

        // Найдём максимум в dp[]
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
