class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        int n = nums.length;
        int prefixSum=0;
        for (int pointer =0; pointer<n;pointer++){
            prefixSum +=nums[pointer];
            int check = prefixSum-k;
            if(map.containsKey(check)){
                count+=map.get(check);
            }
            map.put(prefixSum , map.getOrDefault(prefixSum,0)+ 1);
        }
        return count;
    }
}