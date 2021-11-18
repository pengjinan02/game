package cn.pja.study.leetcode;

import java.util.Arrays;

/**
 * @author 彭金安
 * @DATE 2021/11/12
 */
public class Topic899 {

    public static void main(String[] args) {
        System.out.println(orderlyQueue("abab", 2));
    }

    public static String orderlyQueue(String S, int K) {
        int len=S.length();
        if(K==1){
            String temp=S;
            S=S+S;
            for(int i=0;i<len;i++){
                if(temp.compareTo(S.substring(i,i+len))>0){
                    temp=S.substring(i,i+len);
                }
            }
            return temp;
        }else if(K>1){
            char[] c=S.toCharArray();
            Arrays.sort(c);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<S.length();i++){
                sb.append(c[i]);
            }
            return sb.toString();
        }else{
            return S;
        }
    }
}