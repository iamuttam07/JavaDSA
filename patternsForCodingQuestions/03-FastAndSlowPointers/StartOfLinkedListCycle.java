/*
Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */

class StartOfLinkedListCycle {

    public ListNode findCycleStart(ListNode head) {
        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleLength = findLength(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    public int findLength(ListNode slow) {
        ListNode current = slow;
        int cycLen = 0;
        do {
            current = current.next;
            cycLen++;
        } while (current != slow);
        return cycLen;

    }

    public ListNode findStart(ListNode head, int cycleLength) {
        ListNode p1 = head, p2 = head;
        while (cycleLength > 0) {
            p2 = p2.next;
            cycleLength--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

/*class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = val;
  }
}*/
