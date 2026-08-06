class Solution {
    public int longestConsecutive(int[] nums) {
        int n =nums.length;
        int max=0;
        HashSet<Integer> set = new HashSet<>();
        for (int value : nums){
            set.add(value);
        }
        for (int pointer: set){
            int length_count=0;
            if(set.contains(pointer-1)){
                continue;
            }
            
            int current = pointer;
            while(set.contains(current)){
                length_count++;
                current++;
            }
            
            max= Math.max(length_count,max );
        }
        return max;


    }
}