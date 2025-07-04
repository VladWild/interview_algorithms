package vlad.wild.leetcode.A_Linked_Lists.B;

import java.util.HashSet;
import java.util.Set;

/**
 * Задана head, head связанного списка, определите, есть ли в связанном списке цикл.
 *
 * Цикл в связанном списке есть, если в списке есть некоторый узел, к которому можно снова прийти, непрерывно следуя указателю next.
 * Внутри pos используется для обозначения индекса узла, к которому подключен указатель next в tail.
 * Обратите внимание, что pos не передается как параметр.
 *
 * Верните true, если в связанном списке есть цикл. В противном случае верните false.
 */
public class LinkedListCycleMain {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        boolean b = hasCycle(node0);
        System.out.println(b);
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        nodes.add(head);

        ListNode current = head;

        while (current.next != null) {
            current = current.next;

            if (nodes.contains(current)) {
                return true;
            }

            nodes.add(current);
        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
