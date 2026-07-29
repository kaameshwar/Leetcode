class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i<n;i++){
            if(map.containsKey(nums[i])) return nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return 0;
    }
}