package 剑指offer;

public class HasSubTree17 {
    /*
    题18：树的子结构
    输入两棵二叉树A和B，判断B和A是不是A的子结构。
     */
    /**
     * 解法：采用递归，A的左子树和右子树分别递归去找和B树头结点相同的节点
     * 找到后，再判断A该子节点是否和B树结构相同（左右子树是否相同，还是递归）
     */
    public static boolean hasSubTree(Common.TreeNode rootA, Common.TreeNode rootB) {
        boolean result = false;
        if (rootA != null && rootB != null) {
            if (rootA.val == rootB.val) {
                result = doesTree1HasTree2(rootA, rootB);
            }
            //如果先前找到的相同结点子树和rootb不同，则继续搜索roota的子树
            if (!result) {
                result = hasSubTree(rootA.left, rootB);//先从左子树一层层层找
            }
            if (!result) {
                result = hasSubTree(rootA.right, rootB);//如果左子树没有，再从右子树一层层层找
            }
        }
        return result;
    }

    public static boolean doesTree1HasTree2(Common.TreeNode rootA, Common.TreeNode rootB) {
        if (rootB == null) {
            return true;//判断到B树的叶子节点
        }
        if (rootA == null) {
            return false;
        }
        if (rootA.val != rootB.val) {
            return false;
        }
        return (doesTree1HasTree2(rootA.left, rootB.left) && doesTree1HasTree2(rootA.right, rootB.left));
    }
}
