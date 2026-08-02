class Solution {
    public int majorityElement(int[] nums) {
        int element=0;
        int count =0;
        for (int pointer =0; pointer<nums.length;pointer++){
            if(count==0){
                element = nums[pointer];
            }
            if(nums[pointer]== element){
                count++;
            }
            else{
                count--;
            }
        }
        int freq=0;
        for(int i =0 ;i<nums.length;i++){
            if(nums[i]== element ) freq++;
        }
        if(freq> (nums.length)/2) return element;

        return -1;
    }
}