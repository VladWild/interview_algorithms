package vlad.wild.leetcode.L_Greedy_Problems;

/**
 * Вам дан массив цен, где price[i] — это цена данной акции на i-й день.
 *
 * Вы хотите максимизировать свою прибыль, выбрав один день для покупки одной акции и выбрав другой день в будущем для продажи этой акции.
 *
 * Возвращайте максимальную прибыль, которую вы можете получить от этой сделки. Если вы не можете получить прибыль, верните 0.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};

        int max = maxProfit2(ints);
        System.out.println(max);
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int indexMin = -1;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
                indexMin = i;
            }
        }

        int profit = 0;

        for (int i = indexMin + 1; i < prices.length; i++) {
            int price = prices[i];
            if (price > min) {
                profit = Math.max(profit, price - min);
            }
        }

        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            } else {
                profit = Math.max(profit, price - min);
            }
        }

        return profit;
    }
}
