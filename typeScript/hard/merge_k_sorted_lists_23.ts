/*
 *  https://leetcode.com/problems/merge-k-sorted-lists/ *  

 *  class ListNode {
 *      val: number
 *      next: ListNode | null
 *      constructor(val?: number, next?: ListNode | null) {
 *          this.val = (val === undefined ? 0 : val)
 *          this.next = (next === undefined ? null : next)
 *      }
 *  }
 */

import {ListNode} from "../medium/merge_nodes_in_between_zeros_2181";


function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    let start_output_node: ListNode | null = null
    let last_output_node: ListNode | null = null
    let min_node: ListNode | null = null
    let min_node_index: number = -1
    while (true) {
        min_node = null
        min_node_index = -1
        for (let i = 0; i < lists.length; i++) {
            const start_node_i = lists[i]
            if (start_node_i !== null) {
                if (min_node !== null) {
                    if (min_node.val > start_node_i.val) {
                        min_node = start_node_i
                        min_node_index = i
                    }
                } else {
                    min_node = start_node_i
                    min_node_index = i
                }
            }
        }

        if (min_node_index !== -1) {
            if (start_output_node !== null) {
                last_output_node.next = min_node
                last_output_node = min_node
            } else {
                start_output_node = min_node
                last_output_node = min_node
            }
            // move next node
            lists[min_node_index] = min_node.next
            console.log(min_node.val)
        } else {
            break;
        }
    }
    return start_output_node;
};

mergeKLists([
    new ListNode(1, new ListNode(4, new ListNode(5))),
    new ListNode(1, new ListNode(3, new ListNode(4))),
    new ListNode(2, new ListNode(6))]);
