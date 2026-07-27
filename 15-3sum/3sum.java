class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int sum =0;
        int n = nums.length;
        for (int i =0; i<n-2;i++){
            int left = i+1, right = n-1;
            while(left<right){
                sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        Set<List<Integer>> set = new LinkedHashSet<>(result);
        result = new ArrayList<>(set);

        return result;
    }
}