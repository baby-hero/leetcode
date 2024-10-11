package medium;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
 */
public class TheNumberOfTheSmallestUnoccupiedChair_1942 {
    public static int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> sortedFriendIndexByArrivalTime = new PriorityQueue<>((a, b) -> times[a][0] - times[b][0]);
        for (int i=0; i < times.length; i++) {
            if (times[i][0] < times[targetFriend][0]) {
                sortedFriendIndexByArrivalTime.add(i);
            }
        }
        sortedFriendIndexByArrivalTime.add(targetFriend);

        PriorityQueue<Integer> sortedFriendIndexByLeavingTime = new PriorityQueue<>((a, b) -> times[a][1] - times[b][1]);
        for (int friendIndex: sortedFriendIndexByArrivalTime) {
            sortedFriendIndexByLeavingTime.add(friendIndex);
        }
        int countUsingChair = 0;
        PriorityQueue<Integer> emptySeatsQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> friendToChairMap = new HashMap<>();

        int newArrivalFriendIndex, chairIndexOfLeavingFriend;
        int leavingFriendIndex = -1, leavingTime=-1, smallestChairIndex=0;
        if (!sortedFriendIndexByLeavingTime.isEmpty()) {
            leavingFriendIndex = sortedFriendIndexByLeavingTime.poll();
            leavingTime = times[leavingFriendIndex][1];
        }
        while (!sortedFriendIndexByArrivalTime.isEmpty()) {
            newArrivalFriendIndex = sortedFriendIndexByArrivalTime.poll();
            while (leavingFriendIndex >= 0) {
                if (leavingTime <= times[newArrivalFriendIndex][0]) {
                    chairIndexOfLeavingFriend = friendToChairMap.get(leavingFriendIndex);
                    emptySeatsQueue.add(chairIndexOfLeavingFriend);
                    if (!sortedFriendIndexByLeavingTime.isEmpty()) {
                        leavingFriendIndex = sortedFriendIndexByLeavingTime.poll();
                        leavingTime = times[leavingFriendIndex][1];
                    } else {
                        leavingFriendIndex = -1;
                    }
                } else {
                    break;
                }
            }

            if (emptySeatsQueue.isEmpty()) {
                emptySeatsQueue.add(countUsingChair);
                countUsingChair ++;
            }
            smallestChairIndex = emptySeatsQueue.poll();
            friendToChairMap.put(newArrivalFriendIndex, smallestChairIndex);
        }
        return smallestChairIndex;
    }
    public static void main(String[] args) {
        // Test case 1
        int[][] times1 = {{1,4},{2,3},{4,6}};
        int targetFriend1 = 1;
        System.out.println(smallestChair(times1, targetFriend1)); // Output: 1

        // Test case 2
        int[][] times2 = {{3,10},{1,5},{2,6}};
        int targetFriend2 = 0;
        System.out.println(smallestChair(times2, targetFriend2)); // Output: 2

        // Test case 3
        int[][] times3 = {{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}};
        int targetFriend3 = 6;
        System.out.println(smallestChair(times3, targetFriend3)); // Output: 2
    }
}
