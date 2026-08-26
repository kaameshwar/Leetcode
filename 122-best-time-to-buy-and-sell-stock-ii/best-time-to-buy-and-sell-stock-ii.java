class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit =0;
        for (int pointer = 0; pointer < n-1; pointer++){
            int right = pointer+1;
            if(prices[right] > prices[pointer]){
                profit += prices[right] - prices[pointer];
            }

        }
        return profit;
    }
}