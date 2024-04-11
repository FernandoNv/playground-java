package exercicios.codingProblems.leetcode;

import java.util.Arrays;

public class Q80 {
    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(i+1 < nums.length){
                if(nums[i] == nums[i+1] && nums[i] != Integer.MAX_VALUE){
                    int count = removeDuplicatesAux(i+1, nums);
                    k -= count;
                }
            }
        }

        Arrays.sort(nums);
        return k;
    }

    private static int removeDuplicatesAux(int currentIndex, int[] nums) {
        int count = 0;
        System.out.println(nums[currentIndex]);
        if(currentIndex+1 < nums.length){
            int j = currentIndex+1;
            while(j < nums.length && nums[j] == nums[currentIndex] ){
                nums[j] = Integer.MAX_VALUE;
                j++;
                count++;
            }
        }

        return count;
    }
}
