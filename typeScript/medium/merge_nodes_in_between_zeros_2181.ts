/*
 *
 * https://leetcode.com/problems/regular-expression-matching/
 */

class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

function mergeNodes(head: ListNode | null): ListNode | null {
    console.log("====start =======");
    let start_node: ListNode | null = null
    let last_node: ListNode | null = null;
    let sum = 0;
    while (head != null) {
        if (head.val !== 0) {
            sum += head.val;
        } else {
            if (sum > 0) {
                console.log(sum);
                if (start_node != null) {
                    last_node.next = new ListNode(sum, null);
                    last_node = last_node.next;
                } else {
                    start_node = new ListNode(sum, null);
                    last_node = start_node;
                }
                sum = 0;
            }
        }
        head = head.next;
    }
    console.log("==== end =======");
    return start_node
};

console.log(mergeNodes(
    new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0)))))))))
);

export { ListNode };