class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum =0;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int pointer =0; pointer<n-2;pointer++){
            if(pointer>0 && nums[pointer]== nums[pointer-1]) continue;
            int j = pointer+1 ,right = n-1;
            while(j<right){
            sum = nums[pointer]+nums[j]+nums[right];
            if(sum ==0){
                result.add(Arrays.asList(nums[pointer], nums[j], nums[right]));
                j++;
                right--;

                while(j<right &&nums[j]==nums[j-1]){
                    j++;
                }
                while(j<right&&nums[right] == nums[right+1]){
                    right--;
                }
            }
            else if(sum>0){
                right--;
            }
            else{
                j++;
            }
            }
        }
        return result;
    }
}