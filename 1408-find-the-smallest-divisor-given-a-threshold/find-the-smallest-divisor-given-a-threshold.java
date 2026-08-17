class Solution {
    int calculation(int [] nums, int mid){
        int n =nums.length;
        int ans=0;
        for(int i=0; i<n;i++){
            ans +=Math.ceil((double)nums[i]/ (double)mid);
        }
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left =1;
        int max =0;
        for (int number : nums){
            max=Math.max(max, number);
        }
        int right =max;
        while(left<=right){
            int mid = left+(right-left)/2;
            int divisor = calculation(nums, mid);
            if(divisor>threshold){
                left =mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
}