class Solution {
    public int pivotIndex(int[] nums) {
        int tot =0;
        int left_sum =0;
        for (int num: nums){
            tot+=num;
        }
        int right_sum =0;
        for (int right =0; right<nums.length;right++){
            right_sum = tot-left_sum-nums[right];
            if(right_sum == left_sum){
                return right;
            }
            left_sum +=nums[right];
        }
        return -1;
    }
}