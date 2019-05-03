package com.exercise;

import java.util.List;

public class Wordbreak1 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return false;
        }
        boolean right = false;
        StringBuilder str = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int j = 0;
        for(char i: s.toCharArray()){
            str.append(i);
            temp.append(i);
            String kl = str.toString() + s.substring(j+1, s.length());
            //拼接上后面的情况
            if(wordDict.contains(kl)){
                right = true;
                break;
            }
            else if(!wordDict.contains(str.toString()) && wordDict.contains(temp.toString())){
                right = true;
                temp = new StringBuilder();
                str = new StringBuilder();
            }
            else if(wordDict.contains(str.toString())){
                right = true;
                str = new StringBuilder();
            }
            else{
                right = false;
            }
            j++;
        }
        return right;
    }
}
