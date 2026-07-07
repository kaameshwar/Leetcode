class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int left=0, right=1;

        while(right<prices.length){
            if(prices[right]<prices[left]){
                left = right;
                right++;
            }
            else{
                result = Math.max(prices[right]-prices[left], result);
                right++;

            }
        }
        return result;

        
    }
}