class Solution {
    public int maxSubArray(int[] nums) {
        int current_sum=0;
        int max_sum =Integer.MIN_VALUE;
        int left=0;
        int n =nums.length;
        for (int right=0; right<n;right++){
            current_sum +=nums[right];
            max_sum = Math.max(max_sum,current_sum);
            if(current_sum<0){
                current_sum =0;
                left=right;
            }
        }
        return max_sum;
    }
}