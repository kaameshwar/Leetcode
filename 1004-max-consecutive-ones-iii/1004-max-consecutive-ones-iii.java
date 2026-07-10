class Solution {
    public int longestOnes(int[] nums, int k) {
        int result=0;
        int zero_count=0;
        int left=0;
        for (int right =0; right<nums.length;right++){
            if(nums[right]==0){
                zero_count++;
            }
            while(zero_count>k){
                if(nums[left]==0){
                    zero_count--;
                }
                left++;
            }
            result = Math.max(result, (right-left)+1);
            
        }
        return result;
        
    }
}