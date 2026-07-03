class Solution {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        int left =0;
        int right = n-1;

        for (int i =0; i<n;i++){
            if(nums[i]==0){
                continue;
            }
            else{
                int temp = nums[i];
                nums[i]= nums[left];
                nums[left]= temp;
                left++;
            }
        }
        
    }
}