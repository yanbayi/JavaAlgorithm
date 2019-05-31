package com.zage;

public class Arrayleecode {
    /*
    乘积最大子序列
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4,1,2,3]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
    * */
    public static int maxProduct(int[] nums) {
        int positive = 0;
        int nigetive = 0;
        for (int i = 0;i < nums.length-1; i++){
            int result = nums[i]*nums[i+1];
            if (result > 0 && result > positive){
                positive = result;
            }
            if (result < 0 && result < nigetive){
                nigetive = result;
            }
        }
        return positive;
    }

    public static void main(String[] args) {
        int[] num = {2,3,-2,4,1,2,3};
        System.out.println(maxProduct(num));
    }
}
