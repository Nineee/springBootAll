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
        ArrayList<Integer> ret = new ArrayList<>();
        HashMap<Integer, String> mapOld = new HashMap<>();
        if(s.equals("")){
            return 0;
        }
        if(s.equals(" ") || s.length()==1){
            return 1;
        }

        for(int i=0;i<s.length();i++) {
            String before = String.valueOf(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                String current = String.valueOf(s.charAt(j));
                if (i == 0) {
                    mapOld.put(i, current);
                } else {
                    before = String.valueOf(s.charAt(i - 1));
                }
                if (i > 0 && !current.equals(before) && !mapOld.containsValue(current)) {
                    mapOld.put(i, current);
                } else {
                    if (i > 0 && current.equals(before)) {
                        mapOld.clear();
                        mapOld.put(i, current);
                        continue;
                    }
                    if (i > 0 && mapOld.containsValue(current) && current.equals(before)) {
                        mapOld.clear();
                        continue;
                    }
                    if (i > 0 && mapOld.containsValue(current) && !current.equals(before)) {
                        mapOld.clear();
                        mapOld.put(i - 1, before);
                        mapOld.put(i, current);
                        continue;
                    }
                }
                ret.add(mapOld.size());
            }
            Collections.sort(ret);

        }
        return ret.get(ret.size() - 1);
    }

    @Test
    public void lengthOfLongestSubstringMT(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
