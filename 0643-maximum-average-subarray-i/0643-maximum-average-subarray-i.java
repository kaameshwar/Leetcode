class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double result=0;
        double sum = 0;
        for (int i =0; i<k;i++){
            sum += nums[i];

        }
        result = sum;
        if(sum>result){
            result =sum;
        }

        for (int i =k; i<n;i++){
            sum +=nums[i];
            sum-= nums[i-k];

            if(sum>result){
                result = sum;
            }
        }
        return result/k;
    }
}