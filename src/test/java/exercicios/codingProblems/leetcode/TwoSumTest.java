package exercicios.codingProblems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void twoSum() {
        int[] values = { 1, 3, 8, 2 };
        int[] result = TwoSum.twoSum(values,10);

        Assertions.assertArrayEquals(new int[]{2, 3}, result);
    }

    @Test
    void twoSum1() {
        int[] values = { 3, 9, 13, 7 };
        int[] result = TwoSum.twoSum(values,8);

        Assertions.assertArrayEquals(new int[]{}, result);
    }

    @Test
    void twoSum2() {
        int[] values = { 4, 2, 6, 5, 2 };
        int[] result = TwoSum.twoSum(values,4);

        Assertions.assertArrayEquals(new int[]{1, 4}, result);
    }

    @Test
    void twoSum3() {
        int[] values = { 2, 7, 11, 15 };
        int[] result = TwoSum.twoSum(values,9);

        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }
}