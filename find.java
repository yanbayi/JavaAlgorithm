package com.exercise;
/*
*   题：
*   给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* */
import java.util.Arrays;
import java.util.Scanner;

public class find {
   /*public static int singleNumber(int[] nums) {
        for(int a:nums){
            System.out.print(a+"  ");
        }
        System.out.println();
        Arrays.sort(nums);
        for(int a:nums){
            System.out.print(a+"  ");
        }
        int i = 0;
        while(i<nums.length-1){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
            i += 2;
        }
        return nums[nums.length-1];
    }*/

    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++)
            res ^= nums[i];
        return res;
    }
    public static void main(String[] args) {
        System.out.print("请输入若干数：");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] arr= a.split(" ");
        int[] brr = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            brr[i] = Integer.parseInt(arr[i]);
        }
        int m = singleNumber(brr);
        System.out.println(m);
    }
}
