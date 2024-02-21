package exercicios.codingProblems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q162Test {
    private Q162 q162 = new Q162();

    @Test
    void findPeakElement1() {
        int[] nums = { 1, 2, 3, 1 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(2, index);
    }

    @Test
    void findPeakElement2() {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(5, index); // or 5
    }

    @Test
    void findPeakElement3() {
        int[] nums = { 1 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(0, index);
    }

    @Test
    void findPeakElement4() {
        int[] nums = { 1, 2 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(1, index);
    }

    @Test
    void findPeakElement5() {
        int[] nums = { 2, 1 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(0, index);
    }

    @Test
    void findPeakElement6() {
        int[] nums = { -2147483648 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(0, index);
    }

    @Test
    void findPeakElement7() {
        int[] nums = { 3, 2, 1 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(0, index);
    }

    @Test
    void findPeakElement8() {
        int[] nums = { 1, 3, 2, 1 };
        int index = q162.findPeakElement(nums);
        Assertions.assertEquals(1, index);
    }

}