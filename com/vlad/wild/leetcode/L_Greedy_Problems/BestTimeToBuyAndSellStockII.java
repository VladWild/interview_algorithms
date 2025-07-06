package vlad.wild.leetcode.L_Greedy_Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Вам дан целочисленный массив prices, где prices[i] — это цена данной акции на i-й день.
 *
 * Каждый день вы можете принять решение о покупке и/или продаже акций.
 * Вы можете владеть не более чем одной акцией в любой момент времени.
 * Тем не менее, вы можете купить его, а затем сразу же продать в тот же день.
 *
 * Найдите и верните максимальную прибыль, которую вы можете достичь.
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};

        int max = maxProfit(ints);
        System.out.println(max);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]; // купили вчера, продали сегодня
            }
        }

        return profit;
    }
}
