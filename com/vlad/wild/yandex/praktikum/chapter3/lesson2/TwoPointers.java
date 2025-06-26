package vlad.wild.yandex.praktikum.chapter3.lesson2;

/**
 * Два указателя
 * Найти максимальное число одинаковых подряд идущих символов в строке!
 */
public class TwoPointers {

    public static void main(String[] args) {
        String input = "aaabbccccddee";
        System.out.println(maxConsecutiveElements(input)); // Output: 4
    }

    public static int maxConsecutiveElements(String inputStr) {
        int result = 0;
        int curLetterIdx = 0;

        while (curLetterIdx < inputStr.length()) {
            int nextLetterIdx = curLetterIdx;

            while (nextLetterIdx < inputStr.length() &&
                    inputStr.charAt(nextLetterIdx) == inputStr.charAt(curLetterIdx)) {
                nextLetterIdx++;
            }

            result = Math.max(result, nextLetterIdx - curLetterIdx);
            curLetterIdx = nextLetterIdx;
        }

        return result;
    }
}
