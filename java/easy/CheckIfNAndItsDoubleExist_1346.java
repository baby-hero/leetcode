package easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
 */
public class CheckIfNAndItsDoubleExist_1346 {

    public static boolean checkIfExist(int[] arr) {
        HashMap<Integer, Boolean> checkDoubleOfNumbMap = new HashMap<>();
        HashMap<Integer, Boolean> checkNumbMap = new HashMap<>();

        for (int i : arr) {
            if (checkDoubleOfNumbMap.getOrDefault(i, false) || checkNumbMap.getOrDefault(i * 2, false)) {
                return true;
            }
            checkDoubleOfNumbMap.put(i * 2, true);
            checkNumbMap.put(i, true);
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] testArray1 = {10, 2, 5, 3};
        System.out.println(checkIfExist(testArray1) == true);

        // Test case 2
        int[] testArray2 = {3, 1, 7, 11};
        System.out.println(checkIfExist(testArray2) == false);
    }
}
