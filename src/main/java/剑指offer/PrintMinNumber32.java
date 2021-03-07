package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber32 {
    /*
    题33：把数组排成最小的数
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
    则打印出这3个数字能排成的最小数字321323
     */
    /**
     * 首先想到的是整个数字内数字的全排列，然后比较各个拼接成数字的大小，时间复杂度为n的平方，效率低
     * 另外，还要注意，拼接成的数字可能长度很长，所以应该把拼接成的数字表示成字符串，所以比较的字符串大小
     * 对于全是正整数的字符串(两个字符串长度相同），比较大小，其实就是从字符串最左到右（高位到低位），比较字符的大小
     * 字符都是数字，所以可以通过比较ascii码，字符串从左到右，也就是数字从高位到地位，
     * 所以只要两个字符串(两个字符串长度相同），从左到右比对时，相同最左位有一位小于另一个，则整个字符串表示的数字就小
     * 例如字符串---》32144和32311，a[2]<b[2],也不用管右边的几位，就可以判断a<b
     * 解法一：快排的思想, 将数组内前后两个数字（前后、后前）组成两个字符串，然后比较两个字符串大小，根据此规则
     * 参考元素前的数字，为组数组是排它前面组成数组小的元素，其后相反，然后递归
     * @param array
     * @return
     */
    public static String printMinNumber(int[] array) {
        int[] clone = array;
        StringBuilder stringBuilder = new StringBuilder();
        quickSortArray(clone, 0, clone.length - 1);
        for (int i : clone) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static void quickSortArray(int[] array, int left, int right) {
        if (left >= right || array == null || array.length == 0) {
            return;
        }
        int i = left;
        int j = right;
        int privot = array[left];
        /**
         * 如果参照数字与后面数字组成字符串，参照数字排在前面，则j指针向前移动
         * 如果参照数字与后面数字组成字符串，参照数字排在后面，则i指针向后移动
         * 循环结束后，参照数字之前的数字，都是排在参照数字之前，参照数字之后的数字，都是排在参照数字之后
         * 然后递归
         */
        while (i < j) {
            while (i < j && preOrBehind(String.valueOf(privot), String.valueOf(array[j]))) {
                j--;
            }
            while (i < j && !preOrBehind(String.valueOf(privot), String.valueOf(array[i]))) {
                i++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = privot;
        quickSortArray(array, left, i - 1);
        quickSortArray(array, i + 1, right);
    }

    /**
     * 比较字符大小，前后两个数字各组成一个字符串，从左向右比较字符大小，
     * 如果前面的数字排在后面数字之前组成的字符串小，返回true
     */
    public static boolean preOrBehind(String pre, String behind) {
        String left = pre + behind;
        String right = behind + pre;
//        //两个字符相等则继续循环比对后面的
//        for (int i = 0; i < left.length(); i++) {
//            if (left.charAt(i) < right.charAt(i)) {
//                return true;
//            }
//            if (left.charAt(i) > right.charAt(i)) {
//                return false;
//            }
//        }
        //上面是自己写，也可以直接用jdk的
        /*
        如果参数字符串等于此字符串，则返回值 0；
        如果此字符串小于字符串参数，则返回一个小于 0 的值；
        如果此字符串大于字符串参数，则返回一个大于 0 的值。
         */
        if (left.compareTo(right) < 0) {
            return true;
        } else {
            return false;
        }
    }

    //解法2：利用jdk的 Arrays.sort(Object[] a, Comparator c)
    public static String printMinNumber2(int[] array) {
        if (array == null || array.length == 0) {
            return " ";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        int len = array.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(array[i]);
        }
        /**
         * static <T> void
         * sort(T[] a, Comparator<? super T> c)
         * 根据指定比较器产生的顺序对指定对象数组进行排序。
         * new Comparator<String>为指定比较器
         * arrays.sort是对数组排序，这里是重写排序规则
         */
        Arrays.sort(str, new Comparator<String>() {
            @Override
            /**
             * 重写指定比较器
             * 内部对数组排序规则
             * 比较器会按照比较规则对str进行排序，一直到符合，也就是完成了解法1的快排工作
             */
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        for (int i = 0; i < len; i++) {
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }
}
