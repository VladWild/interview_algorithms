package vlad.wild.leetcode.A_Linked_Lists.С;

public class AddTwoNumbersMain2 {

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
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
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
