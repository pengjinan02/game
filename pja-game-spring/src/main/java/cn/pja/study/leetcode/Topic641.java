package cn.pja.study.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author 彭金安
 * @DATE 2021/11/12
 */
public class Topic641 {

    public static void main(String[] args) {
        String str="abddc";
        char[] chars = str.toCharArray();
        str.substring(1,2);
        Map<Integer, Character[]> map = new HashMap<>();


        Arrays.sort(chars);
        System.out.println(JSON.toJSONString(chars));

        String s = String.valueOf(chars);
        System.out.println(s);

        MyCircularDeque myCircularDeque = new MyCircularDeque(77);
        myCircularDeque.insertFront(89);
        myCircularDeque.getRear();
        myCircularDeque.deleteLast();
        myCircularDeque.getRear();
        myCircularDeque.insertFront(19);
        myCircularDeque.insertFront(23);
        myCircularDeque.insertFront(23);
        myCircularDeque.insertFront(82);
        myCircularDeque.isFull();
        myCircularDeque.insertFront(45);
        myCircularDeque.isFull();
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.toString());
    }
}

class MyCircularDeque {
    int[] que;
    int left;
    int right;
    int k;

    public MyCircularDeque(int k) {
        que = new int[k];
        this.k=k;
        this.left=0;
        this.right=0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        for (int i=0; i < left; i++) {
            que[i+1] = que[i];
        }
        que[0] = value;
        left++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        for (int i= k - right - 1; i < k-1; i++) {
            que[i] = que[i+1];
        }
        que[k-1] = value;
        right++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (left > 0) {
            for (int i= 0; i < left-1; i++) {
                que[i] = que[i+1];
            }
            left--;
        } else {
            right--;
        }

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (right > 0) {
            for (int i= k-1; i > k-right; i--) {
                que[i] = que[i-1];
            }
            right--;
        } else {
            left--;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        if (left != 0){
            return que[0];
        }
        return que[k-right];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        if (right != 0){
            return que[k-1];
        }

        return que[left-1];
    }

    public boolean isEmpty() {
        return left==0 && right==0;
    }

    public boolean isFull() {
        return (left+right)==k;
    }

    @Override
    public String toString() {
        return "MyCircularDeque{" +
                "que=" + Arrays.toString(que) +
                ", left=" + left +
                ", right=" + right +
                ", k=" + k +
                '}';
    }
}
