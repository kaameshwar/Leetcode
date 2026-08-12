class Solution {
    int LowerBound (int [] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int answer = n;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                answer = mid;
                right = mid-1;
            }
            else{
                left =mid+1;
            }
        }
        if(answer==n)return -1;
        return answer;
    }
    int UpperBound(int [] nums, int target){
        int n = nums.length;
        int left =0;
        int right =n-1;
        int answer=n;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                answer=mid;
                right =mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return answer-1;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int [2];
        int first= LowerBound(nums,target);
        if(first ==-1|| nums[first]!=target){
            return new int [] {-1,-1};
        }
        result[0]= first;
        result[1]= UpperBound(nums, target);
        return result;
    }
}