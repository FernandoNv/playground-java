package exercicios.codingProblems.leetcode;
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
//2095. Delete the Middle Node of a Linked List
//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
//
//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
//
//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
//
//
//Example 1:
//
//
//Input: head = [1,3,4,7,1,2,6]
//Output: [1,3,4,1,2,6]
//Explanation:
//The above figure represents the given linked list. The indices of the nodes are written below.
//Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
//We return the new list after removing this node.
//Example 2:
//
//
//Input: head = [1,2,3,4]
//Output: [1,2,4]
//Explanation:
//The above figure represents the given linked list.
//For n = 4, node 2 with value 3 is the middle node, which is marked in red.
//Example 3:
//
//
//Input: head = [2,1]
//Output: [2]
//Explanation:
//The above figure represents the given linked list.
//For n = 2, node 1 with value 1 is the middle node, which is marked in red.
//Node 0 with value 2 is the only node remaining after removing node 1.
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//1 <= Node.val <= 105

public abstract class Q2095 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val + (next != null ? ", " + next.toString() : "");
        }
    }

    public static ListNode deleteMiddleNodeLinkedList(ListNode head){
        if(head == null || head.next == null) return null;

        int middle = sizeListNode(head)/2;
        ListNode middleNode = getNodeByIndex(head, middle);
        ListNode prevNode = getNodeByIndex(head, middle-1);

        prevNode.next = middleNode.next;

        return head;
    }

    public static ListNode getNodeByIndex(ListNode head, int index){
        int count = 0;

        if(head == null) return null;

        while (head.next != null && count < index) {
            count++;
            head = head.next;
        }

        return head;
    }

    public static int sizeListNode(ListNode head){
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}
