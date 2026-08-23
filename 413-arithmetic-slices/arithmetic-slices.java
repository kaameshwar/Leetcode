class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int left =0;
        int n = nums.length;
        if(nums.length<3) return 0;
        int difference = nums[1]-nums[0];
        int count=0;
        for (int right =2; right<n;right++){
            if(nums[right] - nums[right-1] == difference){
                count+= right-left-1;
            }
            else{
                left = right -1;
                difference = nums[right] - nums[right-1];
            }
        }
        return count;
    }
}