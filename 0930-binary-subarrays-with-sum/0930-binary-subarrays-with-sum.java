class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return counter(nums,goal) - counter(nums, goal-1);
    }
    private int counter(int[] nums, int goal) {
        if (goal <0) return 0;
        int count =0, sum =0,left=0;
        for (int right =0; right< nums.length;right++){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            count += (right-left)+1;
        }
        return count;
    }
}