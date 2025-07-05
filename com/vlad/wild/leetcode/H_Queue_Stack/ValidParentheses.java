package vlad.wild.leetcode.H_Queue_Stack;

import java.util.Stack;

/**
 * Если строка s содержит только символы '(', ')', '{', '}', '[' и ']', определите, является ли входная строка действительной.
 *
 * Входная строка допустима, если:
 *
 * Открытые скобки должны быть закрыты тем же типом скобок.
 * Открытые скобки должны быть закрыты в правильном порядке.
 * Каждой закрывающей скобке соответствует открытая скобка того же типа.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);

        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char open = stack.pop();
                    if (!isRight(open, c)) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isRight(char open, char close) {
        return '(' == open && ')' == close
                || '{' == open && '}' == close
                || '[' == open && ']' == close;
    }

    public static boolean isOpen(Character c) {
        return '(' == c || '[' == c || '{' == c;
    }
}
