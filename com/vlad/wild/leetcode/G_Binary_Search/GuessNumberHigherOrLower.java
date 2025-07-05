package vlad.wild.leetcode.G_Binary_Search;

/**
 * Мы играем в игру «Угадай». Игра выглядит следующим образом:
 *
 * Я выбираю число от 1 до n. Вы должны догадаться, какое число я выбрал.
 *
 * Каждый раз, когда вы ошибаетесь, я скажу вам, является ли выбранное мной число больше или меньше вашего предположения.
 *
 * Вы вызываете предопределенный API int guess(int num), который возвращает три возможных результата:
 *
 * -1: Ваше предположение больше, чем число, которое я выбрал (т.е. num > pick).
 * 1: Ваше предположение меньше, чем число, которое я выбрал (т.е. число < выбор).
 * 0: ваша догадка равна числу, которое я выбрал (т.е. num == pick).
 * Возвращаем число, которое я выбрал.
 */

public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.guessNumber(10);
        System.out.println(i); //6 должно быть
    }

    public static class GuessGame {
        int pick = 6; // скрыто от тебя

        int guess(int num) {
            if (num == pick) return 0;
            else if (num < pick) return 1;
            else return -1;
        }
    }

    public static class Solution extends GuessGame {

        public int guessNumber(int n) {
            int left = 1;
            int right = n;

            while (left <= right) {
                int mid = (left + right) / 2;
                int resultApi = guess(mid);
                if (resultApi == 0) {
                    return mid;
                } else if (resultApi == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
}
