class Solution {
    public int longestSubarray(int[] nums) {
        int zerocount=0,left=0;
        int result=0;
        for (int right=0; right<nums.length;right++){
            if(nums[right]!=1){
                zerocount++;
            }
            while(zerocount>1){
                if(nums[left]==0){
                    zerocount--;
                }
                left++;
            }
            result = Math.max(result,right-left);

        }
        if(zerocount==0){
            return nums.length-1;
        }
        return result;

    }
}