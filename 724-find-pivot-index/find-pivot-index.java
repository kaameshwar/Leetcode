class Solution {
    public int pivotIndex(int[] nums) {
        int tot_sum=0;
        int left_sum =0;
        int right_sum =0;
        for (int number : nums){
            tot_sum +=number;
        }

        for (int i =0; i<nums.length;i++){
            right_sum = tot_sum-left_sum-nums[i];
            if(left_sum == right_sum){
                return i;
            }
            left_sum +=nums[i];
        }
        return -1;
    }
}