package com.zage;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
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
            /*
            "aaaa"。"aaa"
            "aaaaaaa";
            */
            if(wordDict.contains(kl)){
                right = true;
                break;
            }
           /*"goalspecial"
             ["go","goal","goals","special"]
           */
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
