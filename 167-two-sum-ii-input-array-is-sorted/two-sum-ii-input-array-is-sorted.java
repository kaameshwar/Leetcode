class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l =0;
        int r = numbers.length-1;
        int [] result = new  int [3];

        for (int i =0; i<numbers.length;i++){
            int value = numbers[l]+numbers[r];
            if (value == target){
                return new int []{l+1,r+1}; 
                
            }
            else if (value>target){
                r--;
            }
            else{
                l++;
            }
        }
        return result;


    }
}