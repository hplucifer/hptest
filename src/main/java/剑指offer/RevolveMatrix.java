package 剑指offer;

public class RevolveMatrix {
    /*
     N*N的矩阵旋转90度，不开辟新空间
     例如：
     1 2 3 4
     5 6 7 8
     9 10 11 12
     13 14 15 16
     */

    /**
     * 逆时针旋转
     * 第一步交换主对角线两侧的对称元素，第二步交换第i行和第n-1-i行，即得到结果
     * 原图：           第一步操作后：   第二步操作后：
     * 1 2 3 4         1 5 9 13        4 8 12 16
     * 5 6 7 8         2 6 10 14       3 7 11 15
     * 9 10 11 12      3 7 11 15       2 6 10 14
     * 13 14 15 16     4 8 12 16       1 5 9 13
     */
    public static void transposeMatrix(int[][] matrix, int n) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null || n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }

    /**
     * 顺时针旋转
     * 第一步交换主对角线两侧的对称元素，第二步交换第i列和第n-1-i列，即得到结果
     * 原图：           第一步操作后：   第二步操作后：
     * 1 2 3 4         1 5 9 13        13 9  5 1
     * 5 6 7 8         2 6 10 14       14 10 6 2
     * 9 10 11 12      3 7 11 15       15 11 7 3
     * 13 14 15 16     4 8 12 16       16 12 8 4
     */
    public static void clockWiseMatrix(int[][] matrix, int n) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null || n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] arg) {
        int[][] a = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        clockWiseMatrix(a, 4);
        for(int i=0; i<4; ++i){
            for(int j=0; j<4; ++j) {
                System.out.print(a[i][j]);
                System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
