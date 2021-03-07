package 剑指offer;

public class MinNumber7 {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
    题8：输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
    例如：数组{1,2,3,4,5},旋转后为{3,4,5,1,2},最小数为1
     */
    public MinNumber7() {}

    /**
     * 二分法，寻找变化点
     * 时间复杂度0（logn），空间复杂度0（1）
     * @param data
     * @return
     */
    public static int minInReversingList(int[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int left = 0;
        int right = data.length - 1;
        int mid = left;//如果移动了0个元素，即传入数组是递增排序，第一个元素就是最小，所以初始化mid为left
        while (data[left] >= data[right]) {
            if (right - left == 1) {
                /**
                 * 当左右相差为1时，一种是数组只有两个元素，那符合while条件下，肯定是移动了，那右边那个肯定是最小的
                 * 另一种是经过while循环，左右相差1，那右边肯定是最小的。
                 */
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (data[left] == data[right] && data[left] == data[mid]) {
                return minInOrder(data, left, right);
            }
            if (data[mid] >= data[left]) {
                left = mid;
            } else if (data[mid] <= data[right]) {
                right = mid;
            }
        }
        return data[mid];
    }

    /**
     * 如果left，right，mid都相等，那就无法通过二分法判断mid是在左边还是在右边，只能选择法遍历数组，得到最小值
     * 选择法，以首元素为参考点
     */
    public static int minInOrder(int[] data, int left, int right) {
        int result = data[left];
        for (int i = left + 1; i <= right; i++) {
            if (result > data[i]) {
                result = data[i];
            }
        }
        return result;
    }

    public static void print1ToN(int n) {
        int[] nums = new int[n];
        int index = 0;
        subPrintNum(nums, index, n);
    }

    public static void subPrintNum(int[] nums, int index, int n) {
        if (index == n) {
            return;
        } else {
            for (int i = 0; i < 10; i++) {
                nums[index] = i;
                subPrintNum(nums, index + 1, n);
                for (int j = index; j < n; j++) {
                    boolean flag = false;
                    if (nums[j] != 0) {

                    }
                }
            }
        }
    }

}
