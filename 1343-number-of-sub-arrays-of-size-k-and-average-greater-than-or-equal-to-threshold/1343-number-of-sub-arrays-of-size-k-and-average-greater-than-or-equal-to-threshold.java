class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int count =0, sum =0;
        for(int i =0; i<k;i++){
            sum+=nums[i];
        }
        if(sum/k>=threshold){
            count=1;
        }
        for (int j=k;j<nums.length;j++){
            sum+=nums[j];
            sum-=nums[j-k];
            if(sum/k >=threshold){
                count++;
            }

        }
        return count;
    }
}