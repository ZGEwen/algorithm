package test;

import java.util.Scanner;

/**
 * @Classname Max
 * @Created by zgw
 * @Date 2020-09-06 10:50
 * @Description TODO
 */
public class Max {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr =new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int li=0,ri=0,max=0;
        for (int i = 0; i < n; i++) {
            li=0;ri=0;
            for (int j = i-1; j >=0; j--) {
                // j从后往前
                if (arr[j]<arr[i]){
                    li=j;
                    break;
                }
            }
            for (int j = i+1; j < n; j++) {
                if (arr[j]>arr[i]){
                    ri=j;
                    break;
                }
            }
             if (max<li*ri){
                max=li*ri;
            }
        }
        System.out.println(max);
    }

}
