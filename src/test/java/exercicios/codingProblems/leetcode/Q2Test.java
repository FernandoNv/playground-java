package exercicios.codingProblems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q2Test {

    @Test
    void addTwoNumbers1() {
        Q2.ListNode node1 = new Q2.ListNode(2);
        Q2.ListNode node2 = new Q2.ListNode(4);
        Q2.ListNode node3 = new Q2.ListNode(3);
        node1.next = node2;
        node2.next = node3;

        Q2.ListNode node4 = new Q2.ListNode(5);
        Q2.ListNode node5 = new Q2.ListNode(6);
        Q2.ListNode node6 = new Q2.ListNode(4);
        node4.next = node5;
        node5.next = node6;

        String expected = "708";
        String actual = Q2.stringify(Q2.addTwoNumbers(node1, node4));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTwoNumbers2() {
        Q2.ListNode node1 = new Q2.ListNode(0);
        Q2.ListNode node2 = new Q2.ListNode(0);

        String expected = "0";
        String actual = Q2.stringify(Q2.addTwoNumbers(node1, node2));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTwoNumbers3() {
        Q2.ListNode node1 = new Q2.ListNode(9);
        Q2.ListNode node2 = new Q2.ListNode(9);
        Q2.ListNode node3 = new Q2.ListNode(9);
        Q2.ListNode node4 = new Q2.ListNode(9);
        Q2.ListNode node5 = new Q2.ListNode(9);
        Q2.ListNode node6 = new Q2.ListNode(9);
        Q2.ListNode node7 = new Q2.ListNode(9);

        Q2.ListNode node8 = new Q2.ListNode(9);
        Q2.ListNode node9 = new Q2.ListNode(9);
        Q2.ListNode node10 = new Q2.ListNode(9);
        Q2.ListNode node11 = new Q2.ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        String expected = "89990001";
        String actual = Q2.stringify(Q2.addTwoNumbers(node1, node8));

        Assertions.assertEquals(expected, actual);
    }
}