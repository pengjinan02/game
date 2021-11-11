package cn.pja.study.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 彭金安
 * @DATE 2021/11/11
 */
public class Topic406 {
    /*假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

    请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
*/
    public static void main(String[] args) {
        int[][] people = new int[][]{
                {7,0},{4,4},
                {7,1},{5,0},
                {6,1},{5,2}
        };
        //System.out.println(people[0].length);
        reconstructQueue(people);
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {return a[1] - b[1];}
            return b[0] - a[0];
        });

        //System.out.println(JSON.toJSONString(people));
        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }

        //System.out.println(JSON.toJSONString(que));
        return que.toArray(new int[people.length][]);
    }
}
