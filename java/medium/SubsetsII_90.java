package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        int count, size;
        result.add(new ArrayList<>());  
        for (int num: numToCount.keySet()) {
            size = result.size();
            for (int j=0; j < size; j++) {
                count = numToCount.get(num);
                List<Integer> baseList = new ArrayList<>(result.get(j));
                for (int t=0;  t < count; t++) {
                    baseList.add(num);
                    result.add(new ArrayList<>(baseList));
                }
            }
        }
        return result;
    }
}
