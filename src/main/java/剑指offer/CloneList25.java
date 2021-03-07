package 剑指offer;

public class CloneList25 {
    /*
    题26：复杂链表的复制
    请实现函数复制一个链表，在复杂链表中，每个结点除了有一个next指针指向下一个结点外，还有一个sibling指针指向链表中的
    任意结点或者null。
     */

    /**
     * 如果是先复制链表结点（遍历0（n），然后在根据原始结点，将复制结点的随机结点指向和原始结点相同的结点（寻找路径，
     * 还是要遍历0（n），那总时间复杂度0（n * n）
     * 解法：先在原链表中复制每个结点且链接在各自结点的后面，那复制后的结点直接就能随机指针指向的和原结点指向就相同路径，
     * 然后根据奇偶拆分链表
     */
     public static class RandomListNode {
         int val;
         RandomListNode next;
         RandomListNode sibling;

         public RandomListNode(int val) {
             this.val = val;
         }
    }

     public static void cloneList(RandomListNode head) {
         if (head == null) {
             return;
         }
         RandomListNode cur = head;
         while (cur.next != null) {
             RandomListNode node = new RandomListNode(cur.val);//复制结点
             node.next = cur.next;
             cur.next = node;
             cur = node.next;
         }
         cur = head;
         while (cur != null) {
             if (cur.sibling != null) {
                 cur.next.sibling = cur.sibling.next;//复制结点的随机指针指向举例和原结点随机指针指向举例相同
                                                     //只不过复制结点随机结点也是在原结点随机指针的next
             }
             cur = cur.next.next;
         }
         //分离链表
         RandomListNode pHead = head.next;
         RandomListNode pClone = pHead;
         cur = head;
         while (cur != null) {
             cur.next = cur.next.next;
             if (cur.next != null) {
                 pClone.next = pClone.next.next;
             }
             pClone = pClone.next;//上面已经先修改了plone.next指针
             cur = cur.next;
         }
     }
}
