class Solution {
    public int singleNumber(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result =0;
        for (int value: nums){
            if(map.containsKey(value)){
                map.put(value, map.get(value)+1);
            }
            else{
                map.put(value, 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                result = entry.getKey();
            }
        }
        return result;
    }
}