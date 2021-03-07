package 剑指offer;

public class FindKthToTail14 {
    /*
    题15：链表中倒数第k个结点
    输入一个链表，输入该链表中倒数第k个结点
     */
    /**
     * 解法：两个指针，第一个先走k步，第二个指向头结点，然后两个一起往前走，当第一个结点走到尾结点，第二个指针指向的就是
     * 倒数第k个结点（n-（n-k））=k
     * 做好防护（链表为空；k为0；链表的结点数少于k），返回null
     */
    public static Common.ListNode findKthToTail(Common.ListNode head, int k) {
        if (head == null || k == 0) {
            return null;//计数是从1开始，所以返回倒数第0个结点没有意义
        }
        Common.ListNode ahead = head;
        Common.ListNode behind = null;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {
                return null;
            }
        }
        behind = head;
        while (ahead.next != null) {
            ahead = ahead.next;//此处没问题，可以
            behind = behind.next;
        }
        return behind;
    }
}
