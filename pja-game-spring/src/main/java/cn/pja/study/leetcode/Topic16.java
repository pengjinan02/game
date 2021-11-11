package cn.pja.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭金安
 * @DATE 2021/11/11
 */
public class Topic16 {
    /*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

    返回这三个数的和。

    假定每组输入只存在恰好一个解。
    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。*/

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        System.out.println(map.getOrDefault(1, 0));
        System.out.println(map.toString());
    }

    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);

        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                // 3个数 前2个+后一个
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }

                // 如果threeSum>target，则需要把threeSum值减小
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }
}
