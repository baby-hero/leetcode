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

function isPalindrome(head: ListNode | null): boolean {
    let left_node = head
    let right_node = head
    function handle(right_node: ListNode | null): boolean {
        if (right_node == null) {
            return true
        }
        const res = handle(right_node.next) && left_node.val == right_node.val;
        left_node = left_node.next;
        return res;
    }
    return handle(right_node);
};