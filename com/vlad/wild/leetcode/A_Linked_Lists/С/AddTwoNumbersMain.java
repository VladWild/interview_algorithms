package vlad.wild.leetcode.A_Linked_Lists.С;

import java.util.Stack;

/**
 * Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
 * Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
 * Сложите два числа и верните сумму в виде связанного списка.
 *
 * Вы можете предположить, что два числа не содержат начальных нулей, кроме самого числа 0.
 */
public class AddTwoNumbersMain {

    public static void main(String[] args) {
        ListNode node01 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node21 = new ListNode(3);
        node01.next = node11;
        node11.next = node21;

        ListNode node02 = new ListNode(5);
        ListNode node12 = new ListNode(6);
        ListNode node22 = new ListNode(4);
        node02.next = node12;
        node12.next = node22;

        ListNode listNode = addTwoNumbers(node01, node02);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = getStack(l1);
        Stack<Integer> stack2 = getStack(l2);

        int sum1 = sum(stack1);
        int sum2 = sum(stack2);

        int sum = sum1 + sum2;
        System.out.println(String.format("sum: %d", sum));

        String s = String.valueOf(sum);

        Stack<Integer> result = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt((s.length() - 1) - i);
            result.push(Integer.parseInt(String.valueOf(c)));
        }

        System.out.println("result: " + result);

        int sum3 = sum(result);

        String s2 = String.valueOf(sum3);
        System.out.println(String.format("s2: %s", sum3));

        ListNode head = new ListNode(Integer.parseInt(String.valueOf(s2.charAt(0))));
        ListNode current = head;

        for (int i = 1; i < s2.length(); i++) {
            char c = s2.charAt(i);
            current.next = new ListNode(Integer.parseInt(String.valueOf(c)));
            current = current.next;
        }

        return head;
    }

    private static int sum(Stack<Integer> stack1) {
        int sum = stack1.pop();
        int i = 0;
        while (!stack1.empty()) {
            ++i;
            sum += stack1.pop() * Math.pow(10, i);
        }
        return sum;
    }

    private static Stack<Integer> getStack(ListNode l1) {
        Stack<Integer> l1Stack = new Stack<>();
        ListNode current = l1;

        while (current != null) {
            l1Stack.push(current.val);
            current = current.next;
        }

        return l1Stack;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
