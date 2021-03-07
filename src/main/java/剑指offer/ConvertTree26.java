package 剑指offer;

public class ConvertTree26 {
    /*
    题27：二叉搜索树与双向链表
    输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     */

    /**
     * 解法：中序遍历，递归
     */
    public static Common.TreeNode convertTree(Common.TreeNode root) {
        Common.TreeNode lastNode = null;
        lastNode = convertNode(root, lastNode);//指向链表尾结点
        Common.TreeNode head = lastNode;
        while (head != null && head.left != null) {
            head = head.left;
        }//从尾向前找到头结点，返回
        return head;
    }

    /**
     * 用lastNode固定左边的结点，不断更新，current固定当前结点，然后lastNode肯定紧靠current，在左边，互相指向形成双向
     * @param root
     * @param lastNode
     * @return
     */
    public static Common.TreeNode convertNode(Common.TreeNode root, Common.TreeNode lastNode) {
        if (root == null) {
            return null;
        }
        Common.TreeNode current = root;

        //左
        if (current.left != null) {
            lastNode = convertNode(current.left, lastNode);
        }
        current.left = lastNode;
        //中
        if (lastNode != null) {
            lastNode.right = current;
        }
        //如果没有右子树，保存当前结点作为左，进入下一步递归，即上一层根结点
        lastNode = current;
        //右
        if (current.right != null) {
            lastNode = convertNode(current.right, lastNode);//如果有右子树，把当前结点和其右子树结点传入，这样当前结点在左，右子树结点在右
                                                            //返回右子树结点，进入下一步递归，即上一层根结点
        }
        return lastNode;
    }
}
