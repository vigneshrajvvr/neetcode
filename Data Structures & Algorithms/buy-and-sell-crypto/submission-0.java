class Solution {
    public int maxProfit(int[] prices) {
               int maxProfit = 0;
        int bought = 0;

        for(int i = 0; i < prices.length; i++) {
            if(i == 0) {
                bought = prices[i];
            } else {
                if(prices[i] < bought) {
                    bought = prices[i];
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - bought);
                }
            }
        }

        return maxProfit; 
    }
}
