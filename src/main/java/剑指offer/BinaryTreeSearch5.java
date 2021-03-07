package 剑指offer;


import java.util.Arrays;

public class BinaryTreeSearch5 {
    /*
    题6：输入二叉树的前序遍历和中序遍历结果，重建该二叉树
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

    /**
     *       10
     *    6      14
     *   4 8    12 16
     * 前序遍历：先访问根结点，再访问左子结点，最后访问右子结点：10，6，4，8，14，12，16
     * 中序遍历：左子结点，根结点，右子结点：4，6，8，10，12，14，16
     * 后序遍历：左子结点，右子结点，根结点：4，8，6，12，16，14，10
     *
     * 思路：
     *   前序遍历的第一个元素为根节点，在中序遍历中找到这个根节点，从而可以将中序遍历分为左右两个部分，
     *   左边部分为左子树的中序遍历，右边部分为右子树的中序遍历，进而也可以将前序遍历除第一个元素以外的剩余部分分为两个部分，
     *   第一个部分为左子树的前序遍历，第二个部分为右子树的前序遍历。
     *   由上述分析结果，可以递归调用构建函数，根据左子树、右子树的前序、中序遍历重建左、右子树。
     */

    /**
     * 解法：递归（传入数组的拷贝）
     * 时间复杂度0(n），空间复杂度0(n）
     * pre前序遍历 in中序遍历
     */

    public static Common.TreeNode reConstrctBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }

        Common.TreeNode root = new Common.TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                //copyOfRange(int[], from, to),to只是用来算拷贝长度，不是数组下标
                root.left = reConstrctBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstrctBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}
