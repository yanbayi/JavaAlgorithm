package com.zage;
/*
* 1.循环报数游戏,有n个人，每一个人编号从1开始，依次编号到n。从1到3报数,报3的退出游戏，得出最后获胜人的编号
     函数原型：public int CyclicGame(int n){ //参数n为人数  }
* */
public class Bao {
   //获胜
    public static int win(boolean arr[],int n){
        int judje = 0;
        for(int i = 0;i < n; i++){
            if(arr[i]==true){
                judje++;
            }
        }
        if(judje <3 ){
            return 1;
        }
        return -1;
    }
    public static int CyclicGame(int n){
        int k = 1;
        boolean[] arr = new boolean[n];
        //初始化
        for(int i = 0;i < n; i++){
            arr[i] = true;
        }
        //遍历
        while(true){
            for(int i = 0;i < n; i++){
                if(arr[i] != false){
                    if(k%3 == 0){
                        arr[i] =false;
                        k++;
                    }else {
                        k++;
                    }
                }
            }
           if(win(arr,n) == 1){
               break;
           }
        }
        for(int i = 0;i < n; i++){
            if(arr[i]==true){
                System.out.println(i);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        CyclicGame(5);
    }
}
