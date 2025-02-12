package easy;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */


// Definition for singly-linked list.



public class MergeTwoSortedList_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = list1;
        if (list1 == null || (list2 != null && list2.val < root.val)) {
            root = list2;
            if (list2 != null) {
                list2 = list2.next;
            }
        } else {
            if (list1 != null) {
                list1 = list1.next;
            }
        }
        ListNode head = root;
        while (list1 != null | list2 != null) {
            if (list1 != null) {
                if (list2 == null || list1.val <= list2.val) {
                    head.next = list1;
                    head = list1;
                    list1 = list1.next;
                    continue;
                }
            }
            head.next = list2;
            head = list2;
            list2 = list2.next;            
        }
        return root;
    }
}
