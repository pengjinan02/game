package cn.pja.study.leetcode;

import org.apache.ibatis.util.MapUtil;

import java.util.*;

/**
 * @author 彭金安
 * @DATE 2021/11/13
 */
public class Topic895 {

    public static void main(String[] args) {
        int head = 0;
        int len = 16;
        int[] a = null;
        int index = (head = (head - 1) & (len - 1));
        int tail = 16;
        tail  = (tail + 1) & (len - 1);
        System.out.println(index + " " + head);
        System.out.println(tail);
        System.out.println(14 & 15);
        Map<Integer, Integer> map = new HashMap<>();
        map.getOrDefault(1,0);
        map.put(1,3);
        System.out.println(map.toString());
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        map2.floorKey(1);

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.naturalOrder());
    }


    class FreqStack {
        Map<Integer, Integer> stack;

        public FreqStack() {
            stack = new LinkedHashMap<>();
        }

        public void push(int val) {
            Deque<Integer> deque = new ArrayDeque<>();
        }

        public int pop() {
            return 0;
        }
    }
}


