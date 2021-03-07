package 剑指offer;

public class TreeDepth38 {
    /*
    题39：二叉树的深度
    （一）输入一个二叉树，求其深度
     */

    /**
     * 如果一颗树只有一个结点，深度为1
     * 如果根结点只有左子树没有右子树，则深度为加上左子树的深度，左子树深度递归
     * 如果根结点只有右子树没有左子树，则深度为加上右子树的深度，右子树深度递归
     * 如果根结点有左右子树，则深度为加上左右子树深度大的，左右子树深度递归
     * 解法：递归
     * 先从左子树开始，到右子树
     */
    public static int treeDepth(Common.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);//注意，这里是返回let+1和right+1，并非left++或right++
                                                       //只要是叶子结点，就没有左右子树，left和right都等于0，此时返回的是该
                                                       //叶子结点所在深度，即返回1，回到其上层根结点
    }

    /*
    (二）判断一个二叉树是不是二叉搜索树
    如果某二叉树中任意结点的左结点小于根结点，右结点大于根结点，那么它就是一颗二叉搜索树
     */
    /**
     * 中序遍历，左--根---右
     * 如果前面大于后面，则返回false
     * 解法：递归
     */
    static Common.TreeNode pre =null;
    static boolean flag = true;
    public static boolean isValidBST(Common.TreeNode root) {
        if(root == null)
            return true;
        inorder(root);
        return flag;
    }

    public static void inorder(Common.TreeNode root){
        if(root != null){
            //左
            inorder(root.left);//先递归到左子树叶子结点
            //中
            if(pre != null && pre.val >= root.val)
                flag = false;
            pre = root;//保存当前结点，作为前者
            //右
            inorder(root.right);
        }
    }

    /*
    (三)判断一个二叉搜索树是不是平衡二叉树
    如果某二叉搜索树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树
     */

    /**
     * 判断一个节点是否平衡，要先遍历该节点的左右子树是否平衡，若都平衡，则该节点平衡，否则该节点就不平衡。
     * 解法1：调用treeDepth方法，获取左右子树深度，如果《=1，则为二叉搜索树
     * 此方法会重复遍历结点多次，效率不好
     * 根结点开始，从上到下，依次判断子树是否是搜索二叉树
     * 要保证每层结点为根结点的子树都是平衡二叉树
     */
    public static boolean isBalance(Common.TreeNode root) {
        if (root == null) {
            return false;
        }
        //先判断根结点是否平衡
        //然后判断子结点为根结点的子树是不是平衡二叉树
        //依次循环
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = Math.abs(left - right);
        if (diff > 1) {
            return false;
        }
        //判断内层结点为根结点的子树
        return isBalance(root.left) && isBalance(root.right);
    }

    /**
     * 解法2：可以使用后序遍历，可以保证每个结点只遍历一次
     */
    private static boolean result = false;
    public static int isBalanceSub(Common.TreeNode root) {
        if (root == null) {
            result = true;
            return 0;
        }
        int left = isBalanceSub(root.left);
        int right = isBalanceSub(root.right);
        //后序遍历，先从下到上层，判断左右子树是否为二叉搜索树
        //每一层都是按规则去判断，深度差小于1
        if (root.val == 8) {
            int hp = 1;
        }
        int diff = Math.abs(left - right);
        if (diff <= 1) {
            result = true;
        } else {
            result = false;
        }
        int depth = 1 + (left > right ? left : right);//节点的深度为左右子树的深度的较大者+1
            //只有一个根结点的二叉树深度是1
        return depth;
    }

    public static boolean isBalance2(Common.TreeNode root) {
        if (root == null) {
            return false;
        }
        isBalanceSub(root);
        return result;
    }
}
