class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int result=0;
        int count=0;
        int i =0;
        while(i<n){
            if(nums[i]!= 0){
                count++;

            }
            else{
                count=0;
            }
            if(count>result){
                result = count;
            }
            i++;

        }

        return result;
        
    }
}