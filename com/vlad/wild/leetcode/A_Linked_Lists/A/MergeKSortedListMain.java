package vlad.wild.leetcode.A_Linked_Lists.A;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Вам предоставляется массив из k списков связанных списков, каждый из которых сортируется в порядке возрастания.
 * Объедините все связанные списки в один отсортированный список ссылок и верните его.
 */
public class MergeKSortedListMain {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode list01 = new ListNode(1);
        ListNode list02 = new ListNode(4);
        ListNode list03 = new ListNode(5);
        list01.next = list02;
        list02.next = list03;
        lists[0] = list01;

        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(3);
        ListNode list13 = new ListNode(4);
        list11.next = list12;
        list12.next = list13;
        lists[1] = list11;

        ListNode list21 = new ListNode(2);
        ListNode list22 = new ListNode(6);
        list21.next = list22;
        lists[2] = list21;

        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || lists[0] == null) {
            return null;
        }

        Queue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (int i = 0; i < lists.length; i++) {
            ListNode elem = lists[i];
            while (elem != null) {
                priorityQueue.add(elem);
                elem = elem.next;
            }
        }

        ListNode minElem = priorityQueue.poll();
        ListNode sortNode = new ListNode(minElem.val);
        ListNode currentNode = sortNode;

        while (!priorityQueue.isEmpty()) {
            minElem = priorityQueue.poll();
            currentNode.next = new ListNode(minElem.val);
            currentNode = currentNode.next;
        }

        return sortNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
