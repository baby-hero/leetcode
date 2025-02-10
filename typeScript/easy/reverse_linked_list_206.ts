/*
 * https://leetcode.com/problems/reverse-linked-list/description/
 */


// Definition for singly-linked list.
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}


function reverseList(head: ListNode | null): ListNode | null {
    let pre_node = null;
    let curr_node = head;
    let next_node;
    while (curr_node != null) {
        next_node = curr_node.next
        curr_node.next = pre_node;
        pre_node = curr_node
        curr_node = next_node
    }
    return pre_node
};