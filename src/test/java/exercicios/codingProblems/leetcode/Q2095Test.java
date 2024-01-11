package exercicios.codingProblems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q2095Test {

    @Test
    void deleteMiddleNodeLinkedList1(){
        var node1 = new Q2095.ListNode(1);
        var node2 = new Q2095.ListNode(3);
        node1.next = node2;
        var node3 = new Q2095.ListNode(4);
        node2.next = node3;
        var node4 = new Q2095.ListNode(7);
        node3.next = node4;
        var node5 = new Q2095.ListNode(1);
        node4.next = node5;
        var node6 = new Q2095.ListNode(2);
        node5.next = node6;
        var node7 = new Q2095.ListNode(6);
        node6.next = node7;
        node7.next = null;

        var newListAfterDeleteMiddleNode = Q2095.deleteMiddleNodeLinkedList(node1);
        var expectedValue = newListAfterDeleteMiddleNode.toString();

        assertEquals("1, 3, 4, 1, 2, 6", expectedValue);
    }

    @Test
    void deleteMiddleNodeLinkedList2(){
        var node1 = new Q2095.ListNode(1);

        var newListAfterDeleteMiddleNode = Q2095.deleteMiddleNodeLinkedList(node1);
        assertNull(newListAfterDeleteMiddleNode);
    }

    @Test
    void deleteMiddleNodeLinkedList3(){
        var node1 = new Q2095.ListNode(1);
        var node2 = new Q2095.ListNode(2);
        node1.next = node2;
        var node3 = new Q2095.ListNode(3);
        node2.next = node3;
        var node4 = new Q2095.ListNode(4);
        node3.next = node4;
        node4.next = null;

        var newListAfterDeleteMiddleNode = Q2095.deleteMiddleNodeLinkedList(node1);
        var expectedValue = newListAfterDeleteMiddleNode.toString();

        assertEquals("1, 2, 4", expectedValue);
    }

    @Test
    void deleteMiddleNodeLinkedList4(){
        var node1 = new Q2095.ListNode(2);
        var node2 = new Q2095.ListNode(1);
        node1.next = node2;
        node2.next = null;

        var newListAfterDeleteMiddleNode = Q2095.deleteMiddleNodeLinkedList(node1);
        var expectedValue = newListAfterDeleteMiddleNode.toString();

        assertEquals("2", expectedValue);
    }
}