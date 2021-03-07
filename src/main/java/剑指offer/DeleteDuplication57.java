package 剑指offer;

public class DeleteDuplication57 {
    /*
    题57：删除链表中重复的结点
     */

    /**
     * 需要注意，头结点可能会重复，那就会删除头结点
     */
    public static Common.ListNode deleteDujplication(Common.ListNode head) {
        if (head == null) {
            return null;
        }
        Common.ListNode pHead = new Common.ListNode(-1);
        pHead.next = head;
        Common.ListNode p = head;
        Common.ListNode pre = pHead;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                pre = p;//保证一直pre一直指向重复结点的前一个结点
            } else {
                pre = p;//保证一直pre一直指向重复结点的前一个结点
                p = p.next;
            }
        }
        return pHead.next;
    }
}
