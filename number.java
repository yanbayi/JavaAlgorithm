import java.util.Scanner;

public class number{
	   //分解整数
    /*public static void emm(){
        System.out.print("请输入5位正整数：");
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int temp = q;
        int wei = 0;
        //算出位数
        while(temp!=0){
            temp = temp/10;
            wei++;
        }
        //判断输入是否正确
        if(q<0 || wei>5){
            System.out.println("输入错误");
            System.exit(-1);
        }
        System.out.println("位数："+wei);
        //顺序输出
        get(q,wei);
        //逆序输出
        System.out.println();
        back(q,wei);
    }
    public static void get(int num,int wei){
        int tmp = num;
        System.out.print("分别是：");
        for(int i = wei;i>0;i--){
            int m1 = (new Double(Math.pow(10,i-1))).intValue();
            tmp = (num/m1)%10;
            System.out.print(tmp+" ");
        }
    }
    public static void back(int num,int wei) {
        Double tmp = Double.valueOf(num);
        System.out.print("逆序是：");
        //获取逆序存入数组element中
        for(int i = 1;i<=wei;i++){
            tmp = (num%Math.pow(10,i))/Math.pow(10,i-1);
            int m1 = (new Double(tmp)).intValue();
            System.out.print(m1+" ");
        }
    }
	public static void main(String[] args) {
       
        emm();
       
    }*/
}
