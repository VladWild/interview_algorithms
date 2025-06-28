package vlad.wild.yandex.praktikum.chapter3.lesson4;

import java.util.Stack;

public class StackMain2 {

    public static void main(String[] args) {

    }

    public static boolean function(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();
                if (!isOpenAndClose(pop, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenAndClose(char open, char close) {
        return open == '(' && close == ')'
                || open == '{' && close == '}'
                || open == '[' && close == ']';
    }

    private static boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
