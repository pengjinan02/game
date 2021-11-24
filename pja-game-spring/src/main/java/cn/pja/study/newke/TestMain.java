package cn.pja.study.newke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 彭金安
 * @DATE 2021/11/19
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = strs.length;
        int index=0;
        String[][] matrix = new String[40][40];
        matrix[index++] = strs;
        for (int i=0; i<n-1; i++) {
            matrix[index++] = bf.readLine().split(" ");
        }

        int num = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> linkServerSet = new HashSet<>();
        for (int i=0; i<index; i++) {
            if (linkServerSet.contains(i)) {
                continue;
            }

            String[] line = matrix[i];
            linkServerSet.add(i);
            for (int j=0; j<line.length; j++) {
                if ("1".equals(line[j]) && !linkServerSet.contains(j)) {
                    queue.offer(j);
                }
            }

            while (queue != null && queue.size() > 0) {
                int lineIndex = queue.poll();
                linkServerSet.add(lineIndex);
                String[] linkLine = matrix[lineIndex];
                for (int j=0; j<linkLine.length; j++) {
                    if ("1".equals(line[j]) && !linkServerSet.contains(j)) {
                        queue.offer(j);
                    }
                }
            }
            num++;
        }
        System.out.println(num);
    }

}
