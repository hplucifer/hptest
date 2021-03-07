package 剑指offer;

public class Common {

    /**
     * 二叉树
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

       public TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 链表
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 获取链表的所有节点
     */
    public static String getAllListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" → ");
            head = head.next;
        }
        return sb.length() < 1 ? null : sb.substring(0, sb.length() - 2);
    }
}
