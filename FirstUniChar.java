package com.zage;

import java.util.ArrayList;
import java.util.List;

public class FirstUniChar {
    public static int firstUniqChar(String s) {
        /*int minIndex = -1;
        for(char ch='a';ch<='z';ch++){
            int index = s.indexOf(ch);
            if(index != -1 && index == s.lastIndexOf(ch)){
                minIndex = minIndex == -1 ? index : (minIndex < index ? minIndex : index);
            }
        }
        return minIndex;*/
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++){
            if((s.indexOf(ss[i]) == s.lastIndexOf(ss[i]))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String k = "leetcode";
        int m = firstUniqChar(k);
        System.out.println(m);
    }
}
