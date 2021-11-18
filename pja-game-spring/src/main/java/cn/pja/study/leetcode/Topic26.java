package cn.pja.study.leetcode;

/**
 * @author 彭金安
 * @DATE 2021/11/18
 */
public class Topic26 {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int newIndex = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[newIndex-1]) {
                break;
            }
            nums[newIndex++] = nums[i];
        }

        return newIndex;
    }
}
