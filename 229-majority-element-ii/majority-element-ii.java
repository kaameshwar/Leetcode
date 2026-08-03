class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int threshold = n/3;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>threshold){
                result.add(entry.getKey());
            }
        }
        return result;

    }
}