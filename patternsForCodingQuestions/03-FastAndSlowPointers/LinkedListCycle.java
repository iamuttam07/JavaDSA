/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */

class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

class ListNode {
    int val = 0;
    ListNode next;

    ListNode(int value) {
        this.val = value;
    }
}
