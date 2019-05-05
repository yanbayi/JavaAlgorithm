package com.zage;

import java.util.Random;
import java.util.Scanner;

public class Puzzle {
    //初始化方格
    public static int[] create(){
        Scanner sc = new Scanner(System.in);
        System.out.print("please input the size you want: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        Random num = new Random();
        for(int i=0 ; i<size ; i++){
            arr[i] = num.nextInt(8)+1;
        }
        arr[size-1] = 0;
        return arr;
    }
    //递归
    public static int run(int[] arr , int i , int now){
        int p = i + arr[Math.abs(i)];
        int m = arr[Math.abs(i)];
        now = now + i;
        if(arr[now] == 0){
            return 1;
        }else if((now+arr[Math.abs(now)]) > arr.length-1){
            System.out.println(now+"->"+(now-arr[Math.abs(now)])+";");
            return run(arr,-arr[Math.abs(now)],now);
        }else if((now+arr[Math.abs(now)]) <= 0){
            return 0;
        }else {
            System.out.println(now+"->"+(now+arr[Math.abs(now)])+";");
            return run(arr,arr[Math.abs(now)],now);
        }
    }


    public static void main(String[] args) {
        int[] arr = create();
        for(int a:arr){
            System.out.print(a+",");
        }
        System.out.println();
        int judge = run(arr,0,0);
        if(judge == 1){
            System.out.println("win");
        }else{
            System.out.println("lose");
        }
    }
}
