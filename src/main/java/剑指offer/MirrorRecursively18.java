package 剑指offer;

import java.util.Stack;

public class MirrorRecursively18 {
    /*
    题19：二叉树的镜像
     */

    /**
     * 解法1：递归
     * 先前序遍历（根左右）这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子结点，当交换完所有非叶子结点的左右子结点后，
     * 就得到了数的镜像
     * treeNode表示的是树，左右子树根结点调换，也就是根结点挂着的子树调换
     */
    public static void mirrorRecursively(Common.TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;//只要左右子结点有一个不为null，都要互换
        }
        Common.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorRecursively(root.left);
        }
        if (root.right != null) {
            mirrorRecursively(root.right);
        }
    }

    /**
     * 解法2：用栈
     */
    public static void mirrorRecursively2(Common.TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<Common.TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            /**
             * 从根结点开始，先交换左子树根结点，然后交换右子树根结点
             */
            while (root != null) {
                Common.TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }
            /**先入后出，从下往上，取出非叶子结点，然后其右子树左右子树
             * 循环中会pop（）出二叉树根结点,从最下层非叶子结点开始，然后进行右子树子结点调换
             */
            root = stack.pop();
            root = root.right;
        }
    }
}
