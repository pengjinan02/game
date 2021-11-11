package cn.pja.study.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author 彭金安
 * @DATE 2021/11/10
 */
public class Solution {
    public static void main(String[] args) {
//        执行用时：
//        2 ms
//                , 在所有 Java 提交中击败了
//        98.97%
//                的用户
//        内存消耗：
//        38.4 MB
//                , 在所有 Java 提交中击败了
//        72.52%
//                的用户
//        通过测试用例：
//        987 / 987
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            // 由于只有128个字符，所以这里获取char转换后asciiCode
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;

    }

}
