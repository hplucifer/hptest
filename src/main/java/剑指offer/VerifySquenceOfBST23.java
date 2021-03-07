package 剑指offer;

import java.util.Arrays;

public class VerifySquenceOfBST23 {
    /*
    题24：二叉搜索树的后序遍历
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
     */

    /**
     *二叉搜索树，左子结点小于根结点，右子结点大于根结点
     * 后序遍历后的数组，最后一个树值是树的根结点，前面可分为两部分，一部分是左子树后序遍历，另一部分是右子树后序遍历
     * 解法：遍历
     */
    public static boolean verifySquenceOfBST(int[] sequence, int length) {
        if (sequence == null || length == 0) {
            return false;
        }
        int root = sequence[length - 1];
        //在二叉搜索树中，左子树的结点小于根结点
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //在二叉搜索树中，右子树的结点大于根结点
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;//初始为true，因为如果没有左子树，则left && right不影响右子树为true的结果，下同
        if (i > 0) {
            left = verifySquenceOfBST(sequence, i);
        }
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < length - 1) { //用i判断
            right = verifySquenceOfBST(Arrays.copyOfRange(sequence, i, length - 1), length - i - 1);//去掉最后一个元素
        }
        return (left && right);
    }
}
