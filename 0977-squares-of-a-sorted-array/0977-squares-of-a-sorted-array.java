class Solution {
    public int[] sortedSquares(int[] nums) {
        int left =0;
        int right = nums.length-1;
        int result_pos = nums.length-1;
        int [] arr= new int[nums.length];

        while(left<=right){
            int left_square = nums[left]*nums[left];
            int right_square = nums[right]*nums[right];

            if(right_square >left_square){
                arr[result_pos]= right_square;
                right--;
                result_pos--;
            }
            else{
                arr[result_pos]= left_square;
                left++;
                result_pos--;
            }
        }
        return arr;
        
    }
}