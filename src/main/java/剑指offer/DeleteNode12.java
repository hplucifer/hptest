package 剑指offer;

public class DeleteNode12 {
    /*
    题13：在0（1）时间内删除链表结点
    给定单向链表的头节点指针和一个结点指针，定义一个函数在0(1)时间删除结点
    (题目要求时间复杂度为0（1），则默认给定结点肯定在链表内，不然如果还包含结点不在链表内，则只能遍历，时间复杂度为0（n））
     */

    /**
     * 首先想到的是遍历，找到value相等的结点删除，这样时间复杂度为0（n）
     * 解法：可以用给定结点的下一个结点对该结点进行覆盖,相当于删除该结点
     */
    public static void deleteNode(Common.ListNode head, Common.ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return;
        }
        if (tobeDelete.next != null) { //位于链表内
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;//这样该结点已经不在于链表中
        } else if (head == tobeDelete) { //此处表示链表只有一个头结点时，第一个if
            //表示链表有多个结点，要删除的结点在链表内，也包含了要删除结点是头结点的情况
            head = null;
        } else { //位于链表尾部，需要遍历
            Common.ListNode pNode = head;
            /**
             * 如果要删除的结点位于链表的尾部，那就没有下一个结点，只能够从头节点开始顺序遍历到该结点的前结点
             * ，然后删除该结点
             * 顺序查找时间复杂度为0(n），总的平均时间复杂度为[(n-1)*0(1)+0(n)]/n = 0(1)
             */
            while (pNode.next != tobeDelete) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }
}
