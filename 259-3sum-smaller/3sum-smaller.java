class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        // int right = nums.length-1;
        int ans = 0;
        for (int pointer = 0; pointer <n-2; pointer++){
            int mid = pointer+1;
            int right = nums.length-1;
            while(mid<right){
                if(nums[pointer]+ nums[mid]+ nums[right]<target){   
                    ans += right - mid;
                    mid++;
                }
                else{
                    right --;
                }

            }
        }
        return ans;
    }
}