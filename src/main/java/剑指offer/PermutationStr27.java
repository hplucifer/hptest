package 剑指offer;

import java.util.ArrayList;

public class PermutationStr27 {
    /*
    题28：字符串的全排列
    输入一个字符串，打印出该字符串中字符的所有排列。
    例如，给定字符a，b，c所能排列的字符串abc、acb、bac、bca、cab、cba
     */

    /**
     * 解法：把字符串分成两部分，一部分是字符串的第一个字符，另一部分是剩下的，递归
     */
    public static ArrayList<String> permutationStr1(char[] str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length == 0) {
            return list;
        }
        permutation(list, 0, str);
        return list;
    }

    public static void permutation(ArrayList<String> list, int index, char[] str) {
        if (index == str.length - 1) { //此处是str.length - 1，没必要<str.length，这样已经可以打印全排列
            list.add(String.valueOf(str));
            return;
        }
        /**
         * abc---acb---abc（还原为原顺序，然后第一个字符串交换下面递归过程如此）---bac---bca---bac
         * ---abc---cba---cab--cba---abc
         */
        for (int i = index; i < str.length; i++) {
            swap(str, index, i);//固定第一个字符
            permutation(list, index + 1, str);//递归交换另一部分字符顺序
            swap(str, index, i);//还原为原字符顺序，继续递归排序
        }
    }

    public static void swap(char[] output, int i, int j) {
        char temp = output[i];
        output[i] = output[j];
        output[j] = temp;
    }
}
