package com.nineee.springboot.web;

import org.junit.Test;

import java.util.*;

/**
 * @Author: ljj
 * @Date: 2019/6/26 16:43
 * @Desc
 */
public class LeeCodeQue {


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashMap<Integer, String> mapOld = new HashMap<>();
        if(s.equals("")){
            return 0;
        }
        if(s.equals(" ") || s.length()==1){
            return 1;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(i==0){
                mapOld.put(i,String.valueOf(c));
                result = 1;
            }
            if(i>0&&!String.valueOf(c).equals(s.charAt(i-1))){
                result = result +  1;
                mapOld.put(i,String.valueOf(c));
            }
        }
        return mapOld.size();
      /*  int key = 0;
        int value = 0;
        int flagKey = 0;
        int flagValue = 0;
        Set<Map.Entry<Integer, Integer>> entries = mapResult.entrySet();
        for(Map.Entry entry :entries){
            key = Integer.valueOf(entry.getKey().toString());
            value = Integer.valueOf(entry.getValue().toString());
            if(flagValue < value ) {
                flagKey  = key;
                flagValue = value;
            }
        }
        return flagValue;
*/
    }

    @Test
    public void lengthOfLongestSubstringMT(){
        System.out.println( lengthOfLongestSubstring("wwkew"));
    }
}
