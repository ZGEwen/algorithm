package matrix;

/**
 * @Classname PrintMatrixSpiralOrder
 * @Created by zgw
 * @Date 2018-12-03 12:22
 * @Description 转圈打印矩阵
 */
public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            //左上角的点向右向下移动，右下角的点向左向上移动
            //左上角的点保证是在左上角，即左上角的行和列有一个错过去，便结束
            //每次打印一个框
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     *
     * @param m 数组
     * @param tR 左上角点的行
     * @param tC 左上角点的列
     * @param dR 右下角点的行
     * @param dC 右下角点的列
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        //左上角和右下角在同一行
        if (tR == dR) {
            //同一行的数据
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            //左上角和右下角在同一列
            //同一列的数据
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            //边界为矩形框形式
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}
