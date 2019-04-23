package com.exercise;

import java.util.Arrays;
import java.util.Scanner;

/*
*
*       给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
*       你可以假设数组是非空的，并且给定的数组总是存在众数。
*
*       从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
*
* */
public class Majority {
    //9ms
    /*public Integer majorityElement(int[] nums) {
        //大于数组长度一般的为众数，也就是说这个数长度不小于一半 最短 len/2 + 1
        Arrays.sort(nums);
        int arrayLen = nums.length;
        Integer resultInt = null;
        for(int i : nums) {//循环遍历数组
            if(i == nums[ arrayLen / 2 ]){
                resultInt = i;
            }
        }
        return resultInt;
    }*/
    //7ms
    /*public static int majorityElement(int[] nums) {
        int i = 1;
        Arrays.sort(nums);
        int k = 0;
        if(nums.length == 1){
            return nums[0];
        }
        while(k<nums.length-1){
            if(nums[k] == nums[k+1]){
                i++;
                if(i>(nums.length/2)){
                    return nums[k];
                }
            }else{
                i=1;
            }
            k++;
        }
        return -1;
    }*/
    //4ms
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 1){
            return nums[0];
        }

        return nums[nums.length/2];
    }*/
    //2ms  同归于尽
    public static int majorityElement(int[] nums) {
        int num = nums[0], count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == num) {
                count++;
            } else if(--count < 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
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
        int b = majorityElement(brr);
        System.out.println(b);
    }
}
