/*
Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Example 1:
Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true

Example 2:
Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
Output: false
 */

class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode secondHalfCopy = secondHalf;

        while (head != null && secondHalf != null) {
            if (head.val != secondHalf.val) return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
        // reverse(secondHalfCopy);
        // if(head == null && secondHalf == null)
        // return true;
        // return false;
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