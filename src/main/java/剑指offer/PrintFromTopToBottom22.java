package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom22 {
    /*
    题23：从上往下（按层）打印二叉树
    从上往下打印出二叉树的每个结点，同一层的结点按从左到右的顺序打印
     */

    /**
     * 每一次打印一个结点的时候，如果该结点有子结点，则把该结点的子结点放到一个队列的末尾。接下来到队列的头部
     * 取出最早进入队列的结点，递归
     * 解法：递归,运用队列的FIFO性质
     */
    public static ArrayList<Integer> printFromToBottom(Common.TreeNode root) {
        if (root != null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Common.TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Common.TreeNode node = ((LinkedList<Common.TreeNode>) queue).pop();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
