/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function deleteDuplicates(head: ListNode | null): ListNode | null {
    let ind_node = head;
    if (head != null) {
        let curr_node = head.next;
        while (curr_node != null) {
            if (curr_node.val == ind_node.val) {
                curr_node = curr_node.next;
            } else {
                ind_node.next = curr_node;
                ind_node = curr_node;
                curr_node = curr_node.next;
            }
        }
        if (ind_node.next != null) {
            ind_node.next = null;
        }
    }
    return head;
};