package 剑指offer;

public class EntryNodeOfLoop56 {
    /*
    题56：链表中环的入口结点
    一个链表包含环，如何找出环的入口结点
     */

    /**
     * 如果一个链表有环，则环内有n个几点，定义两个指针，指向链表头结点，一个先走n步，另一开始走，当两个指针相遇时的结点，就是入口结点
     * 首先，判断链表中是否有环，两个指针，一个先走，一个后走，如果相遇，则链表内有环，且相遇的结点肯定在环内
     * 然后，确定环内有几个结点,通过相遇结点，作为开始结点，然后下次再到该结点时，经过的结点个数就是环内结点数
     * 解法：判断是否有环，找出环内结点，从而找出入口结点
     */
    public static Common.ListNode findEntyNodeOfLoop(Common.ListNode head) {
        Common.ListNode meetingNode = meetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        int loopNodeCount = 0;
        while (meetingNode.next != meetingNode) {
            meetingNode = meetingNode.next;
            loopNodeCount++;
        }
        Common.ListNode fastNode = head;
        for (int i = 0; i < loopNodeCount; i++) {
            fastNode = fastNode.next;
        }
        Common.ListNode slowNode = head;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return  fastNode;
    }

    public static Common.ListNode meetingNode(Common.ListNode head) {
        if (head == null) {
            return null;
        }
        Common.ListNode slowNode = head.next;
        if (slowNode == null) {
            return null;
        }
        Common.ListNode fastNode = slowNode.next;
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;//让fastnode走快一些
            }
        }
        return null;
    }
}
