package cn.pja.study.leetcode;

/**
 * @author 彭金安
 * @DATE 2021/11/14
 */
public class Topic494 {

    public static void main(String[] args) {
        Topic494 topic494 = new Topic494();
        int[] nums = new int[]{1,0};
        int target =1;
        int a = topic494.findTargetSumWays(nums, target);

        int[][] aa = new int[3][];
        System.out.println(aa.length);
        //System.out.println(aa[2] + 1);

        System.out.println(a);
    }

    public int closedIsland(int[][] grid) {
        int num=0;
        for (int i=0; i<grid.length; i++) {
            int[] line = grid[i];
            for (int j=0; j<line.length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                boolean flag = false;
                if (i != 0) {
                    flag |= grid[i-1][j]==1;
                }
                if (j != 0) {
                    flag |= grid[i][j-1]==1;
                }
                if (i != grid.length-1) {
                    flag |= grid[i+1][j]==1;
                }
                if (j != line.length-1) {
                    flag |= grid[i][j+1]==1;
                }

                if (!flag) {
                    num++;
                }
            }
        }
        return 0;
    }

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int methodNum = 0;
        methodNum += addSum(nums, target, 0, 0, "+");
        methodNum += addSum(nums, target, 0, 0, "-");
        return methodNum;
    }

    private int addSum(int[] nums, int target, int sum, int index, String str) {
        if ("-".equals(str)) {
            sum -= nums[0];
        } else {
            sum += nums[0];
        }

        if (index == nums.length-1) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int methodNum = 0;
        methodNum += addSum(nums, target, sum, index+1, "+");
        methodNum += addSum(nums, target, sum, index+1, "-");
        return methodNum;
    }
}
