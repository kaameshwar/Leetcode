class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return count_subarrays(nums,k) - count_subarrays(nums, k-1);
        
    }
    private int count_subarrays(int[] nums, int k){
        int odd_count =0;
        int left=0;
        int total_count = 0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]%2!=0){
                odd_count++;
            }
            while(odd_count>k){
                if(nums[left]%2!=0){
                    odd_count--;
                }
                left++;
            }
            total_count+=(right-left)+1;

        }
        return total_count;
    }
}