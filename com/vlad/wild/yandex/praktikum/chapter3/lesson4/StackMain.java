package vlad.wild.yandex.praktikum.chapter3.lesson4;

import java.util.Stack;

/**
 * Проверка правильности скобочной последовательности
 */
public class StackMain {

    public static void main(String[] args) {
        String str = "{}(())[]{}[](())";

        boolean valid = isValid(str);
        System.out.println("Valid: " + valid);
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            var symbol = str.charAt(i);

            if (isOpen(symbol)) {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (!isMatching(stack.pop(), symbol)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isOpen(char symbol) {
        return symbol == '(' || symbol == '{' || symbol == '[';
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
