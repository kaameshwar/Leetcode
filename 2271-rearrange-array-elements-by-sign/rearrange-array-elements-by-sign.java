class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positive =0;
        int negative =1;
        int n = nums.length;
        int [] result = new int [n];
        for (int pointer=0; pointer<n;pointer++){
            if(nums[pointer]>0){
                result[positive]= nums[pointer];
                positive+=2;
            }
            else{
                result[negative]= nums[pointer];
                negative+=2;
            }
        }
        return result;
    }
}