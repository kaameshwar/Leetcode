class Solution {
    public int maxArea(int[] height) {
        int right = height.length-1;
        int left =0;
        int max_capacity = 0;
        while(left<right){
            int hgt = Math.min(height[left], height[right]);
            int width = right -left;
            int result = hgt*width;
            max_capacity = Math.max(max_capacity, result);
            if(height[left]< height[right]){
                left++;
            }
            else if(height[left]>height[right]){
                right--;
            }
            else {
                right--;
                left++;

            }

        }
        return max_capacity;
    }
}