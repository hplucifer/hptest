package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] arg) {
        Common.TreeNode root = new Common.TreeNode(8);
        Common.TreeNode node1 = new Common.TreeNode(6);
        Common.TreeNode node2 = new Common.TreeNode(10);
        Common.TreeNode node3 = new Common.TreeNode(1);
        Common.TreeNode node4 = new Common.TreeNode(7);
        Common.TreeNode node5 = new Common.TreeNode(9);
        Common.TreeNode node6 = new Common.TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeDepth38.isBalance2(root);
    }

    public static ArrayList<Integer> printList(Common.ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            if (head.next != null) {
                list = printList(head.next);
            }
            list.add(head.val);
        }
        return list;
    }

    public static Common.TreeNode dinaryTree(int[] pre, int[] mid) {
        Common.TreeNode root = new Common.TreeNode(pre[0]);
        int i = 0;
        for (; i < pre.length; i++) {
            if (mid[i] == pre[0]) {
                break;
            }
        }
        root.left = dinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(mid, 0, i));
        root.right = dinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(mid, i + 1, mid.length));
        return  root;
    }

    public static void print1N(int n) {
        int[] nums = new int[n];
        subPrint(nums, 0);
    }

    public static void subPrint(int[] nums, int index) {
        for (int i = 0 ; i < 10; i++) {
            if (index != nums.length) {
                nums[index] = i;
                subPrint(nums, index + 1);
            } else {
                boolean flag = false;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        flag = true;
                    } else {
                        if (flag) {

                        }
                    }
                }
            }
        }
    }


}
