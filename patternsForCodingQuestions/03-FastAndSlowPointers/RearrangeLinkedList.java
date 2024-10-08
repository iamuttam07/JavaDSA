/*
Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the
second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return
1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
Your algorithm should use only constant space the input LinkedList should be modified in-place.

Example 1:
Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null

Example 2:
Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */

class RearrangeLinkedList {

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
             fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;

        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }
        if (headFirstHalf != null) headFirstHalf.next = null;

        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}

/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}*/