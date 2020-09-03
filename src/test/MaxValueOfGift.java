package test;

import java.util.Scanner;

/**
 * @Classname MaxValueOfGift
 * @Created by zgw
 * @Date 2020-08-29 19:10
 * @Description 能拿的礼物最大值
 */
public class MaxValueOfGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int m=Integer.parseInt(str[0]);
        int n=Integer.parseInt(str[1]);
        int[][] arr =new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print(maxValue(arr));
    }
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(j == 0 && i == 0) continue;
                if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }
                else if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }
                else if(j != 0 && i != 0){
                    grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
