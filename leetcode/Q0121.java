package leetcode;

public class Q0121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int i = 1 ; i < prices.length ; i++) {
            if(min > prices[i]) {
                min = prices[i];
                continue;
            }

            if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }

        return maxProfit;
    }
}
