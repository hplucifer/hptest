package 剑指offer;

public class MergeList16 {
    /*
    题17：合并两个排序的链表
    输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然按照递增排序。
    */
    /**
     * 解法：递归
     * 当我们得到两个链表中值较小的头结点并把它连接到已经合并的链表之后，两个链表剩余的结点已然是排序的，这是个递归的过程
     */
    public static Common.ListNode mergeList(Common.ListNode head1, Common.ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Common.ListNode mergeListHead = null;
        if (head1.val < head2.val) {
            mergeListHead = head1;
            mergeListHead.next = mergeList(head1.next, head2);
        } else {
            mergeListHead = head2;
            mergeListHead.next = mergeList(head1, head2.next);
        }
        return mergeListHead;
    }
}
