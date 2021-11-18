package cn.pja.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭金安
 * @DATE 2021/11/15
 */
public class Topic6 {
    public static void main(String[] args) {
        Long num = 1L;
        for (int i=1; i<7; i++) {
            num+=num;
        }
        System.out.println(num);
    }

    public int myAtoi(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i=0; i < len; i++) {
            if (chars[i] == ' ') {
                continue;
            }
        }
        return 0;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static String convert(String s, int numRows) {
        int zSize = numRows * 2 - 2;
        int len = s.length();
        int zNum = len / zSize;
        int cNum = len % zSize;

        char[] chars = new char[1000];
        int index = 0;
        for (int row=0; row<numRows; row++) {
            int num=0;
            for (; num<zNum; num++) {
                chars[index++] = s.charAt(row+num*zSize);
                if (row != 0 && row != numRows-1) {
                    chars[index++] = s.charAt((num+1)*zSize-row);
                }
            }

            if (cNum > row) {
                chars[index++] = s.charAt(row+num*zSize);
                if (row != 0 && row != numRows-1 && cNum > zSize-row ) {
                    chars[index++] = s.charAt((num+1)*zSize-row);
                }
            }
        }
        return String.valueOf(chars);
    }
}
