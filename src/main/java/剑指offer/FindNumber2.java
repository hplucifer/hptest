package 剑指offer;

public class FindNumber2 {
    /*
    题2：在一个二维数组中，每一行按照从左到右递增的顺序排序，每一列按照从上到下的顺序排序。请完成一个函数，
    输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
    例如

    1  2  8  9
    2  4  9  12
    4  7  10 13
    6  8  11 15

    查找整数7
     */

    /**
     * 解法1：双指针,时间复杂度 0(mn) 空间复杂度0(1)
     * 选取数组中右上角的数字。如果该数字等于要查找的数字，查找结束；如果该数字大于要查找的数字，踢出这个数字所在的列；
     * 如果该数字小于要查找的数字，踢出这个数字所在的行。这样每一步都可以缩小要查找的范围
     */
    public static boolean find(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int row = 0;
        /**
         * 二位数组行数：array.length
         * 二位数组列数：array[0].length
         */
        int column = array[0].length - 1;

        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 解法2：二分法，时间复杂度 0(logm*logn=log(mn)) 空间复杂度 0(1)
     * 遍历查找有序数组，时间复杂度 0(n)
     * 二分法，用于顺序排列的有序数组，n/2, n/2*2......n/2^k, n/2^k=1,k=log2n, 0(logn)
     */

    /**
     * 矩阵每一行、每一列均为有序，把整体二位数组当作一维的，进行二分搜索就可以
     * 只不过需要根据一维数组对应二位数组的规则将一维的index转为二维的index
     */
    public static boolean find2(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int left = 0;
        int right = array.length * array[0].length - 1;//二维当作一维
        int column = array[0].length;//列数

        while (left <= right) {
            int mid = (left + right) / 2;
            /*
            取整体的中间一个元素，将该元素对应的index转为二维数组所在位置
            一维数组该元素的index除总列数取余数为二维数组的行
            一维数组该元素的index除总列数取模为二维数组的列
             */
            int value = array[mid / column][mid % column];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
