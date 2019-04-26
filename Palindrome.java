package com.exercise;
/*
*   验证回文串
*       给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
*
*       说明：本题中，我们将空字符串定义为有效的回文串。
*       示例 1:
*       输入: "A man, a plan, a canal: Panama"
*       输出: true
*       示例 2:
*       输入: "race a car"
*       输出: false
* */
import java.util.ArrayList;

public class Palindrome {
    //17ms
    /*public static boolean isPalindrome(String s) {
        char[] b = s.toCharArray();
        ArrayList<String> c = new ArrayList<>();
        for(int i = 0;i < b.length; i++){
            if(((int)b[i]>64&&(int)b[i]<91)){
                b[i] += 32;
            }
            if( ((int)b[i]>47&&(int)b[i]<58) || ((int)b[i]>96&&(int)b[i]<123)){
                c.add(String.valueOf(b[i]));
            }
        }
        int d = c.size()-1;
        for(int p = 0;p <c.size();p++){
            if(!c.get(p).equals(c.get(d))){
                return false;
            }
            if(d==p){
                return true;
            }
            d--;

        }
        return true;
    }*/
    //7ms
    public static boolean isPalindrome(String s) {
        if(s==""||s==null) return true;
        char[] b = s.toCharArray();
        int l = 0;
        int r = b.length-1;
        while(l<r){
            if(((int)b[l]>64&&(int)b[l]<91)){
                b[l] += 32;
            }
            if(((int)b[r]>64&&(int)b[r]<91)){
                b[r] += 32;
            }
            if(((int)b[l]>47&&(int)b[l]<58) || ((int)b[l]>96&&(int)b[l]<123)){
                if(((int)b[r]>47&&(int)b[r]<58) || ((int)b[r]>96&&(int)b[r]<123)){
                    if(b[l] != b[r]){
                        return false;
                    }
                    l++;
                    r--;
                }else r--;
            }else l++;
            if(l == r){
                return true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String aa = "";
        System.out.println(isPalindrome(aa));
    }
}
