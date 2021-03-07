package 剑指offer;

import java.util.Stack;

public class FindFirstCommonNode36 {
    /*
    题37：两个链表的第一个公共链表
    两个链表都为单向链表
     */

    /**
     * 首先想到的是暴力查找，即遍历第一个链表，每取出一个就遍历第二个链表，直到发现相同（next相同，val相同）的，时间复杂度0（mn），效率低
     * 解法：利用栈, 时间复杂度0（m+n），但是需要开辟空间
     * 可以想到，因为是单向链表，如果两个链表有公共结点，那么从第一个公共结点开始，后面两个链表都是指向一个结点，类似Y形状
     * 所以可以从后往前对比，直到最后一个相同结点，那么这个结点也是两个链表的第一个公共结点
     * 链表是只能从头遍历，所以想到了FILO特性的栈
     */
    public static Common.ListNode findFirstCommonNode(Common.ListNode head1, Common.ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<Common.ListNode> stack1 = new Stack<>();
        Stack<Common.ListNode> stack2 = new Stack<>();
        Common.ListNode result = null;

        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek().val == stack2.peek().val) {
                result = stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 解法2：两个链表同步从头往下一个结点前进，相同位置结点对比，时间复杂度也是0（m+n），而且不需要开辟空间，提高了空间效率
     * 要考虑两个链表长度不同的情况，长链表先走多出长度步数，然后同步对比
     * 需要遍历链表得出长度
     */
    public static Common.ListNode findFirstCommonNode2(Common.ListNode head1, Common.ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Common.ListNode p1 = head1;
        Common.ListNode p2 = head2;
        int len1 = geLength(p1);
        int len2 = geLength(p2);
        int different = 0;
        if (len1 - len2 > 0) {
            different = len1 - len2;
            while (different > 0) {
                head1 = head1.next;//len1-len2>0说明不止head
                different--;
            }
        } else {
            different = len2 - len1;
            while (different > 0) {
                head2 = head2.next;
                different--;
            }//different>0跳过了长度相等情况
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public static int geLength(Common.ListNode head) {
        int len = 0;
        Common.ListNode h = head;
        while (h != null) {
            len++;
            h = h.next;
        }
        return len;
    }
}
