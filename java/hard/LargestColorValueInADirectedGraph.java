package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/
 */
public class LargestColorValueInADirectedGraph {

     public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        
        if (n <= 0) {
            return -1;
        }
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        int[] indg = new int[n];
        for (int[] e : edges){
            map[e[0]].add(e[1]);
            indg[e[1]]++;
        }
        int[][] memo = new int[n][26];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (indg[i] == 0){
                memo[i][colors.charAt(i)-'a']++; // base case
                queue.offer(i);
            }
        }

        int ans = 0;
        while(!queue.isEmpty()){
            --n;
            int cur = queue.poll();
            if (map[cur].size()==0){ // update ans at leave nodes
                ans = Math.max(ans, Arrays.stream(memo[cur]).max().getAsInt());
            }
            for (int next : map[cur]){
                for (int i = 0; i < 26; i++){ // forward the max to the next node
                    memo[next][i] = Math.max(memo[next][i], memo[cur][i] + (i == colors.charAt(next)-'a'? 1 : 0));
                }
                if (--indg[next]==0){
                    queue.offer(next);
                }
            }
        }
        return n==0?ans:-1;
    }

    public static void main(String[] args) {
        // Test case 1
        String colors1 = "abaca";
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        System.out.println(largestPathValue(colors1, edges1) == 3);

        // Test case 2
        String colors2 = "a";
        int[][] edges2 = {{0, 0}};
        System.out.println(largestPathValue(colors2, edges2) == -1);
    }
}
