package test;

import java.util.Scanner;

/**
 * @Classname Apple
 * @Created by zgw
 * @Date 2020-09-05 15:32
 * @Description 分苹果，n个苹果取x个，每个的重量为正整数，重量总和为偶数时可以分
 */
public class Apple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for (int i=0;i<a;i++){
            int n=sc.nextInt();
            int x=sc.nextInt();
            int[] appleW=new int[n];
            int number=0;
            for (int j = 0; j < n; j++) {
                appleW[j]=sc.nextInt()%2;
                if (appleW[j]==1){
                    number++;
                }
            }
            int need=0,type=0;
            while (need <=x ) {
                if ( x-need<=n-number){
                    type=1;
                    break;
                }
                need=need+2;
            }
            if (type==1){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }

    }
}
