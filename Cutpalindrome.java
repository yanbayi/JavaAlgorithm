package com.exercise;

import java.util.List;

/*
*    分割回文串
*       给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
*       返回 s 所有可能的分割方案。
*       示例:
*       输入: "aab"
*       输出:
*       [
*         ["aa","b"],
*         ["a","a","b"]
*       ]
* */

public class Cutpalindrome {

   /* List<List<String>> result = new ArrayList<>();
    List<String> list = new ArrayList<>();
    char[] arr;
    String s;

    void core(int index){
        // 从index开始分割
        if (index == arr.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < arr.length; i++){
            if (isHW(index,i)){
                list.add(s.substring(index,i + 1));
                core(i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isHW(int left,int right){
        int L = left,R = right;
        while (L <= R){
            if (arr[L++] != arr[R--]){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        arr = s.toCharArray();
        this.s = s;
        core(0);
        return result;
    }*/

    public static void main(String[] args) {

    }
}
