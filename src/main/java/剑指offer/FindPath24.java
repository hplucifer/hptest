package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class FindPath24 {
    /*
    题25：二叉树中和为某一值的路径
    输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    从树的根结点开始往下一直到叶子结点所经过的结点形成一条路径
     */

    /**
     * 先前序遍历二叉树，因为只有前序遍历是先访问根结点
     * 使用栈，压入弹出的过程
     * 解法：递归，往树深处前进一直到叶子结点，从左到右
     */
    public static void FindPath(Common.TreeNode root, int expectsSum) {
       if (root == null) {
           return;
       }

        ArrayList<Integer> list = new ArrayList<>();
        int currentSum = 0;
        printFindPath(root, expectsSum, list, currentSum);
    }

    /**
     * Java方法参数中的值传递和引用传递
     * 变量是值传递，currentsum传入上一层的值，下一层只在本层修改其值，并不会返回修改后currentsum的值，除非作为方法结果返回。
     * 实例是引用传递，作为方法参数，会在方法内修改其值返回
     * @param root
     * @param expectsSum
     * @param list
     * @param currentSum
     */
    public static void printFindPath(Common.TreeNode root, int expectsSum, ArrayList<Integer> list, int currentSum) {
        currentSum += root.val;
        list.add(root.val);

        boolean isLeaf = (root.left == null && root.right == null);
        if (currentSum == expectsSum && isLeaf) {
            System.out.println("path is find");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        if (root.left != null) {
            printFindPath(root.left, expectsSum, list, currentSum);
        }
        if (root.right != null) {
            printFindPath(root.right, expectsSum, list, currentSum);
        }
        list.remove(list.size() - 1);
    }
}
