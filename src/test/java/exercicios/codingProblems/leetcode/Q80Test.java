package exercicios.codingProblems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q80Test {

    @Test
    void removeDuplicates1() {
        int[] nums = { 1,1,1,2,2,3 };
        int[] expectedNums = { 1,1,2,2,3 };
        int k = Q80.removeDuplicates(nums);

        Assertions.assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(nums[i], expectedNums[i]);
        }
    }

    @Test
    void removeDuplicates2() {
        int[] nums = { 1,1,1 };
        int[] expectedNums = { 1,1 };
        int k = Q80.removeDuplicates(nums);

        Assertions.assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(nums[i], expectedNums[i]);
        }
    }

    @Test
    void removeDuplicates3() {
        int[] nums = { 2,2,3,6,7,8,8,8,8,8,8,8,8,8,8,8,9 };
        int[] expectedNums = { 2,2,3,6,7,8,8,9 };
        int k = Q80.removeDuplicates(nums);

        Assertions.assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(nums[i], expectedNums[i]);
        }
    }
}