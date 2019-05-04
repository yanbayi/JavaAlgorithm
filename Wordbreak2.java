package com.zage;

import java.util.ArrayList;
import java.util.List;

/*
*  单词拆分 II
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
* */
public class Wordbreak2 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();

        //dp 判断能否拆分
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0 ;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String k = s.substring(j,i);
                if(dp[j] && wordDict.contains(k)){
                    dp[i]=true;
                    break;
                }
            }
        }
        int l = s.length();
        if(!dp[l]){
            return res;
        }

        StringBuilder ssr = new StringBuilder();
        dfs(s,wordDict,ssr,res,0);
        return res;
    }

    private static void dfs(String s,List<String> wordDict,StringBuilder ssr,List<String> res,int start){

        if(start == s.length()){
            res.add(ssr.toString().trim());
            return;
        }

        for(int i=start+1;i<=s.length();i++){
            String str = s.substring(start,i);
            if(wordDict.contains(str)){
                int length = ssr.length();
                ssr.append(str).append(" ");
                dfs(s,wordDict,ssr,res,i);
                ssr.setLength(length);
            }
        }
    }

    public static void main(String[] args) {
        List<String> p = new ArrayList<>();
        p.add("aaaaa");
        p.add("aa");
        p.add("aaa");
        System.out.println(wordBreak("aaaaa",p));

    }
}
