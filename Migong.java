package com.exercise;
import java.util.Stack;

class point{
    int x;
    int y;
    int u,d,l,r;//四个搜索方向
    int way;
    int hang,lie;
    //初始化所在点
    public point(int x, int y,int p,int q,int[][] a,int wei){
        this.x = x;
        this.y = y;
        hang = p;
        lie = q;
        way = wei;
        //上
        if(x-1<0 || a[x-1][y] == 1){
            u = 1;
        }
        //下
        if(x+1 > lie || a[x+1][y] == 1){
            d = 1;
        }
        //左
        if(y-1 < 0 || a[x][y-1] == 1){
            l = 1;
        }
        //右
        if(y+1 > hang ||a[x][y+1] == 1){
            r = 1;
        }
        if(wei == 2){u=1;}
        if(wei == 1){d=1;}
        if(wei == 4){l=1;}
        if(wei == 3){r=1;}
    }
    //克隆当前所在点信息
    public point(point p){
        this.u = p.u;
        this.d = p.d;
        this.l = p.l;
        this.r = p.r;
        this.x = p.x;
        this.y = p.y;
        this.hang = p.hang;
        this.lie = p.lie;
    }
}
public class Migong {
    //向前走一步迷宫
    public static void run(point p){
        if(p.u == 0){
            p.x -= 1;
            p.u = 1;
            p.way = 1;
        }else if(p.d == 0){
            p.x += 1;
            p.d = 1;
            p.way = 2;
        }else if(p.l == 0){
            p.y -= 1;
            p.l = 1;
            p.way = 3;
        }else if(p.r == 0){
            p.y += 1;
            p.r = 1;
            p.way = 4;
        }
    }
    //封锁走过点的路
    public static void stop(point p){
        if(p.u == 0){
            p.u = 1;
            p.way = 1;
        }else if(p.d == 0){
            p.d = 1;
            p.way = 2;
        }else if(p.l == 0){
            p.l = 1;
            p.way = 3;
        }else if(p.r == 0){
            p.r = 1;
            p.way = 4;
        }
    }
    //打印迷宫
    public static void dayin(Stack<point> pan,int[][] a){
        while ( pan.empty()!= true ){
            a[pan.peek().x][pan.peek().y] = 2;
            //System.out.println("("+pan.peek().x+","+pan.peek().y+")"+"-->");
            pan.pop();
        }
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //设置迷宫尺寸
        final int hang = 4;
        final int lie = 4;
        //迷宫
        int a[][]={ {0,0,0,0,1},//00    01    02   03    04
                    {1,0,1,0,1},//10    11    12   13    14
                    {0,0,1,0,1},//20    21    22   23    24
                    {1,0,0,0,0},//30    31    32   33    34
                    {1,1,0,0,0}};
        /*int a[][]={{0,1,1},
                    {0,0,0},
                    {1,1,1}};*/
        Stack<point> pan = new Stack<>();//push   peek不删   pop删   empty
        //记录下一步的点位
        int aa = 0;
        int b =0;
        int c = 0;

        point p1 = new point(aa, b, hang, lie, a, c);
        pan.push(p1);
        while (true) {
            if(!(pan.peek().u==1 && pan.peek().d==1 && pan.peek().l==1 && pan.peek().r==1)){
                point tmp = new point(pan.peek());
                run(tmp);
                stop(pan.peek());
                aa = tmp.x;
                b = tmp.y;
                c = tmp.way;
                p1 = new point(aa, b, hang, lie, a, c);
                pan.push(p1);
            }else{
                if(pan.peek().x==hang && pan.peek().y==lie){
                    System.out.println("u get the way");
                    dayin(pan,a);
                    System.exit(0);
                }
                if(pan.peek().x==0 && pan.peek().y==0){
                    System.out.println("no way");
                    System.exit(0);
                }
                pan.pop();
                p1 = new point(pan.peek());
            }
        }
    }
}
