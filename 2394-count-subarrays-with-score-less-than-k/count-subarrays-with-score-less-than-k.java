class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum =0,score =0;
        int left=0;
        long len=0;
        for (int right =0;right<nums.length;right++){
            sum +=nums[right];
            score = sum*((right-left)+1);
            while(score >=k){
                sum-=nums[left];
                left++;
                score = sum*((right-left)+1);
                
            }
            len +=(right-left)+1;
        }
        return len;
    }
}