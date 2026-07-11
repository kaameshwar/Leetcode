class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count=0;
        if(nums.length<3){
            return 0;
        }
        int diff = nums[1]-nums[0];
        int left =0;
        for (int right =2; right<nums.length;right++){
            if(nums[right]-nums[right-1]== diff){
                count+= right-left-1;
            }
            else{
                diff = nums[right]-nums[right-1];
                left = right-1;
            }
            
            
        }
        return count;
    }
}