package easy;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
**/

 public class BestTimeToBuyAndSellStock_121 {
    
    public static int maxProfit(int[] prices) {
        int res = 0, min = prices[0];
        for (int i=1; i < prices.length; i++) {
            if (res < prices[i] - min) {
                res = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] testArray1 = {7,1,5,3,6,4};
        System.out.println(maxProfit(testArray1) == 5);

        // Test case 2
        int[] testArray2 = {7,6,4,3,1};
        System.out.println(maxProfit(testArray2) == 0);
    }
}
