package ti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sushu {
    //判断素数
    public static void sushu(){
        int n;
        Scanner sr = new Scanner(System.in);
        n = sr.nextInt();
        int x = 2;
        if(n == 2)
            System.out.print(n+"是素数");
        while(x <= n){
            if( n%x == 0){
                System.out.print(n+"不是素数");
                break;
            }else if(x == n){
                System.out.print(n+"是素数");
            }
            x++;
        }
    }
    //100以内的素数
    public static void sushu100(){
        List<Integer> y = new ArrayList<Integer>();
        List<Integer> n = new ArrayList<Integer>();
        int a,b;
        for(a = 1;a<= 100;a++){
            for(b = 2;b<=a;b++){
                if (a%b == 0){
                    break;
                }
            }
            if(a==b){
                y.add(b);
            }else{
                n.add(a);
            }
        }
        System.out.println("素数:");
        for(Integer tmp:y){
            System.out.print(tmp+" ");
        }
        System.out.println("");
        System.out.println("非素数:");
        for(Integer tmp:n){
            if(tmp%20==0)
                System.out.println(" ");
            System.out.print(tmp+" ");
        }
    }
    public static void main(String[] args) {
        sushu();
        sushu100();

    }
}
