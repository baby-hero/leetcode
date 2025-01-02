package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-vowel-strings-in-ranges
 */

public class CountVowelStringsInRanges_2559  {

    private static final Set<Character> VOWEL_LETTERS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] countVowelStrings = new int[n+ 1];
        for (int i = 0; i < n; i++) {
            // if (words[i].matches("^[aeiou](.*[aeiou]+)?$")){
            if (
                VOWEL_LETTERS.contains(words[i].charAt(0)) && 
                VOWEL_LETTERS.contains(words[i].charAt(words[i].length() - 1))
            ) { 
                countVowelStrings[i + 1] = countVowelStrings[i] + 1;
            }
            else {
                countVowelStrings[i + 1] = countVowelStrings[i];
            }
        }
        int[] result= new int[queries.length];
        for (int i=0; i<queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = countVowelStrings[right + 1] - countVowelStrings[left];
        }
        return result; 
    }
    public static void main(String[] args) {
        String[] words = new String[] {"aba","bcb","ece","aa","e"};
        int[][] queries = new int[][] {{0,2},{1,4},{1,1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries))); // Output: "[2,3,0]"
        words = new String[] { "a", "e", "i" };
        queries = new int[][] {{0,2}, {0,1}, {2,2}};
        System.out.println(Arrays.toString(vowelStrings(words, queries))); // Output: "[3,2,1]"
        words = new String[] {
            "bzmxvzjxfddcuznspdcbwiojiqf","mwguoaskvramwgiweogzulcinycosovozppl","uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs",
            "uivcdsboxnraqpokjzaayedf","yalc","bbhlbmpskgxmxosft","vigplemkoni","krdrlctodtmprpxwditvcps","gqjwokkskrb",
            "bslxxpabivbvzkozzvdaykaatzrpe","qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi","siqbezhkohmgbenbkikcxmvz",
            "ddmaireeouzcvffkcohxus","kjzguljbwsxlrd","gqzuqcljvcpmoqlnrxvzqwoyas",
            "vadguvpsubcwbfbaviedr", "nxnorutztxfnpvmukpwuraen","imgvujjeygsiymdxp",
            "rdzkpk","cuap","qcojjumwp",
            "pyqzshwykhtyzdwzakjejqyxbganow","cvxuskhcloxykcu","ul",
            "axzscbjajazvbxffrydajapweci"
        };
        queries = new int[][] {{4, 4},{6, 17},{10, 17},{9, 18},{17, 22},{5, 23},{2, 5},{17, 21},{5, 17},{4, 8},{7, 17},{16, 19},{7, 12},{9, 20},{13, 23},{1, 5},{19, 19}};
        System.out.println(Arrays.toString(vowelStrings(words, queries))); // Output: "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]"
    }
}
