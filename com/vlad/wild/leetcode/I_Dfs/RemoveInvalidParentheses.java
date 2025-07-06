package vlad.wild.leetcode.I_Dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Дана строка s, которая содержит скобки и буквы, удалите минимальное количество недопустимых скобок, чтобы сделать входную строку действительной.
 * Верните список уникальных строк, которые действительны с минимальным количеством удалений. Вы можете вернуть ответ в любом порядке.
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String str = "()())()"; //["(())()","()()()"]

        List<String> strings = removeInvalidParentheses(str);
        System.out.println(strings);
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean foundValid = false;

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (isValid(str)) {
                result.add(str);
                foundValid = true;
            }

            // как только нашли валидный уровень — дальше не идём
            if (foundValid) continue;

            // генерируем строки с одной удалённой скобкой
            for (int i = 0; i < str.length(); i++) {
                // пропускаем не-скобки
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;

                String next = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return result;
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static class Info {
        int level;
        boolean isValid;
        String string;

        public Info(int level, String string) {
            this.level = level;
            this.string = string;
        }
    }
}
