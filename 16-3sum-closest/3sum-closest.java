class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum =0;
        int closest=0;
        int minsum =Integer.MAX_VALUE;
        int n = nums.length;
        for (int i =0; i<n-2;i++){
            for (int j =i+1; j<n-1; j++){
                for (int k =j+1;k<n;k++){
                    sum = nums[i]+nums[j]+nums[k];
                    if(sum == target){
                        return target;

                    }
                    int difference = Math.abs(sum - target);

                    if(difference <minsum){
                        minsum = difference;
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }
}