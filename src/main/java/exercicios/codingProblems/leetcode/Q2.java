package exercicios.codingProblems.leetcode;

// 2. Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
//Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carried = sum > 9 ? 1 : 0;
        ListNode l3 = new ListNode(sum % 10);
        ListNode head = l3;

        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carried;
            carried = sum > 9 ? 1 : 0;
            ListNode l3N = new ListNode(sum % 10);
            l3.next = l3N;

            l1 = l1.next;
            l2 = l2.next;
            l3 = l3N;
        }

        while (l1 != null) {
            sum = l1.val + carried;
            carried = sum > 9 ? 1 : 0;

            ListNode l3N = new ListNode(sum % 10);
            l3.next = l3N;

            l1 = l1.next;
            l3 = l3N;
        }

        while (l2 != null) {
            sum = l2.val + carried;
            carried = sum > 9 ? 1 : 0;

            ListNode l3N = new ListNode(sum % 10);
            l3.next = l3N;

            l2 = l2.next;
            l3 = l3N;
        }

        if (carried > 0) {
            l3.next = new ListNode(carried);
        }

        return head;
    }

    public static String stringify(ListNode listNode){
        StringBuilder stringBuilder = new StringBuilder();
        while(listNode != null){
            stringBuilder.append(listNode.val);
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }
}
