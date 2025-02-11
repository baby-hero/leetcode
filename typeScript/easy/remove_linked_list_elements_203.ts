/*
 * https://leetcode.com/problems/remove-linked-list-elements/
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

function removeElements(head: ListNode | null, val: number): ListNode | null {
    let current_node = head;
    while (current_node != null && current_node.val == val) {
        current_node = current_node.next;
    }
    const new_root = current_node;
    let pre_node = null;
    while (current_node != null) {
        if (current_node.val == val) {
            current_node = current_node.next;
            if (pre_node != null) {
                pre_node.next = current_node;
            }
        } else {
            pre_node = current_node;
            current_node = current_node.next
        }
    }
    return new_root;
};