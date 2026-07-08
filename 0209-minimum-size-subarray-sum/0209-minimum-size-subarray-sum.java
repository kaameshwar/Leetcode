class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right =0;
        int sum =0;
        int result = Integer.MAX_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            if(sum<target){
                right++;
            }
            else{
                while(sum>=target){
                    result = Math.min(result, (right-left)+1);
                    sum-=nums[left];
                    left++;
                }
                right++;
            }
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return result;
        }
        
    }
}