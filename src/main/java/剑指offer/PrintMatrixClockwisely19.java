package 剑指offer;

public class PrintMatrixClockwisely19 {
    /*
    题20：顺时针打印矩阵
    输入一个矩阵，按照顺时针从外到里打印矩阵的每一个数字
     */
    public static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int start = 0;
        while (matrix.length > 2 * start && matrix[0].length > 2 * start) {
            printMatrixInCircle(matrix, matrix[0].length, matrix.length, start);
            start++;
        }
    }

    public static void printMatrixInCircle(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; i++) {
            System.out.println(matrix[start][i]);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(matrix[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.println(matrix[endY][i]);
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.println(matrix[i][start]);
            }
        }
    }
}
