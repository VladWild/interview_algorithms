package vlad.wild.yandex.praktikum.chapter3.lesson8;

/**
 * У тебя есть:
 *      - n предметов
 * У каждого есть:
 *      - вес w[i]
 *      - ценность v[i]
 * Рюкзак может вместить не более W веса
 * Тебе нужно выбрать некоторые предметы (не более одного каждого), чтобы максимизировать суммарную ценность, но не превысить вес W.
 */
public class BackpackMain {

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values  = {1, 4, 5, 7};
        int maxWeight = 7;

        int maxValue = knapsack(weights, values, maxWeight);
        System.out.println("Максимальная ценность: " + maxValue); // 9
    }

    public static int knapsack(int[] w, int[] v, int W) {
        int n = w.length; //количество предметов
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) { //i - номер предмета, который можно взять
            for (int j = 0; j <= W; j++) { //j - текущая допустимая грузоподъемность
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
