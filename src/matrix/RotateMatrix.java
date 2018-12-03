package matrix;

/**
 * @Classname RotateMatrix
 * @Created by zgw
 * @Date 2018-12-03 12:40
 * @Description 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成
 * 顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 */
public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     *
     * @param m
     * @param tR 左上角的行
     * @param tC 左上角的列
     * @param dR 右下角的行
     * @param dC 右下角的列
     *           a      b
     *
     *
     *           c      d
     */
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        //需要交换的次数
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            //顺时针旋转90度
            //存储a
            tmp = m[tR][tC + i];
            //c赋值给a
            m[tR][tC + i] = m[dR - i][tC];
            //d赋值给c
            m[dR - i][tC] = m[dR][dC - i];
            //b赋值给d
            m[dR][dC - i] = m[tR + i][dC];
            //a赋值给b
            m[tR + i][dC] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }
}
