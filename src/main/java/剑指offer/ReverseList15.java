package 剑指offer;

public class ReverseList15 {
    /*
    题16：反转链表
    定义一个函数，输入一个链表的头结点，反转该链表，并返回反转后链表的透结点
     */

    /**
     * 解法：定义三个指针，分别指向当前遍历到的结点、它的前结点、它的后结点
     * 如果只是调整链表中结点的指针方向，那会造成链表之间的断裂
     * 先拿出头结点作为尾结点，然后确定前一个结点，将该结点指向头结点，依次往左进行
     */
    public static Common.ListNode reverseList(Common.ListNode head) {
        Common.ListNode reverseHead = null;
        Common.ListNode node = head;
        Common.ListNode pre = null;
        while (node != null) {
            Common.ListNode next = node.next;//保存该结点的后结点
            if (next == null) {
                reverseHead = node;//原链表尾结点下一个结点为空，为反转链表的头结点
            }
            //从头结点开始调整链表方向
            node.next = pre;//将原链表的下一个结点指向上一个结点
            pre = node;//保存当前结点
            node = next;//返回原列表结点顺序
        }
        return reverseHead;
    }
}
