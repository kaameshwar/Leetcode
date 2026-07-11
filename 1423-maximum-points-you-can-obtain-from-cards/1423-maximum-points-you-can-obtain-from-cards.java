class Solution {
    public int maxScore(int[] cards, int k) {
        int left_sum = 0;
        int right_sum =0;
        int rindex = cards.length-1,result=0;
        for (int i =0 ;i<k;i++){
            left_sum+=cards[i];
        }
        result = left_sum;
        for (int i =k-1;i>=0;i--){
            left_sum-=cards[i];
            right_sum += cards[rindex];
            rindex--;
            
            result = Math.max(result, left_sum+right_sum);
        }
        return result;
        
    }
}