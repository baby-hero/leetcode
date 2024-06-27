/*
 * https://leetcode.com/problems/find-center-of-star-graph/
 */
function findCenter(edges: number[][]): number {
    const nodes_set = new Set();
    for (let edge of edges) {
        for (let node of edge) {
            if (!nodes_set.has(node)) {
                nodes_set.add(node);
            }
            else {
                return node;
            }
        }
    }
};

console.log(findCenter([[1,2],[5,1],[1,3],[1,4]]) === 1);
console.log(findCenter([[1,2],[2,3],[4,2]]) === 2);
