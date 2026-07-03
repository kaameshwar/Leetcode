class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
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
        int maxfreq = 0;
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(entry.getValue()>maxfreq){
                maxfreq = entry.getValue();
                result = entry.getKey();
            }
            else{
                continue;
            }
        }

        return result;

        
    }
}