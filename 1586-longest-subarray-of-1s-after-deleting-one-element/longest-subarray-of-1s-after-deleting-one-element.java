class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left =0;
        int ZeroCount =0;
        int answer = Integer.MIN_VALUE;
        for (int right =0; right < n; right ++){
            if(nums[right]== 0){
                ZeroCount++;
            }
            while(ZeroCount>1){
                if(nums[left]==0){
                    ZeroCount--;
                }
                left++;
            }
            answer = Math.max(answer, right-left);
        }
        return answer;
    }
}