class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest=0;
        int minDifference = Integer.MAX_VALUE;
        int n = nums.length;
        int sum =0;
        for (int i =0; i<n-2;i++){
            int left = i+1, right = n-1;
            while(left<right){
                sum = nums[i]+nums[left]+nums[right];

                if(sum ==target){
                    return target;
                }
                int difference = Math.abs(sum-target);
                if(difference <minDifference){
                    minDifference = difference;
                    closest = sum;
                }
                if(sum>target){
                    right--;

                }
                else{
                    left++;
                }
            }
        }
        return closest;
        
    }
}