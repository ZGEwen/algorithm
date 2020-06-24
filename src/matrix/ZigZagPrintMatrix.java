package matrix;

/**
 * @Classname ZigZagPrintMatrix
 * @Created by zgw
 * @Date 2018-12-03 13:03
 * @Description TODO
 */
public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            //a向右→，b向下↓，每次移动一位
            //a到最右开始向下→↓，b到最下开始向右↓→
            //方向从上到下串↙和从下向上串↗交替进行
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                //↙
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                //↗
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }

}
