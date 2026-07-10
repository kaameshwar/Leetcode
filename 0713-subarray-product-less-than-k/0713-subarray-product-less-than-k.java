class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0;
        int count =0,product=1;

        if(k<=1) return 0;

        for (int right =0; right<nums.length;right++){
            product *= nums[right];
            if(product<k){
                count += (right-left)+1;
            }
            else{
                while(product>=k){
                    product/=nums[left];
                    left++;
                }
                count+=(right-left)+1;
            }
        }

        
        return count;
        
    }
}