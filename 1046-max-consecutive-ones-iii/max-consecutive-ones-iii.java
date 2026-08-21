class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int answer = Integer.MIN_VALUE;
        int left =0;
        int ZeroCount = 0;
        for (int right =0; right < n; right++){
            if(nums[right]==0){
                ZeroCount++;
            }

            while(ZeroCount > k){
                if(nums[left]==0){
                    ZeroCount--;
                }
                left++;
            }
            answer = Math.max(answer, (right-left)+1);

            // if(nums[right]==0){
            //     ZeroCount++;
            // }
            // answer = Math.max(answer, (right-left)+1);
        }
        return answer;
    }
}