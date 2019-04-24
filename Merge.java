package com.exercise;
/*
*   给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
* 说明:
*   初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
*   你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
*
* */
public class Merge {
    //1ms
    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(j>=0){
            nums1[k--] = i >= 0 && nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];

        }
    }*/

    public static void merge(int nums1 [], int m, int nums2 [], int n){
        int i = m-1, j = n-1, k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0};
        int[] num2 = {2,3};

    }
}
