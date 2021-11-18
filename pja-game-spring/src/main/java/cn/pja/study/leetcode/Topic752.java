package cn.pja.study.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭金安
 * @DATE 2021/11/14
 */
public class Topic752 {
    public static void main(String[] args) {
        Topic752 topic752 = new Topic752();
        System.out.println(JSON.toJSONString(topic752.get("0000")));
        int[][] ans = new int[4][2];
        for (int[] ansColor : ans) {
            //初始化所有距离为MAX
            ansColor[0] = Integer.MAX_VALUE;
            ansColor[1] = Integer.MAX_VALUE;
        }
        System.out.println(JSON.toJSONString(ans));
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }
}
