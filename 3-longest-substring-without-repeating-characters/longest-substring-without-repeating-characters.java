class Solution {
    public int lengthOfLongestSubstring(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int answer = 0;
        for (int right =0; right<str.length();right++){
                while(map.containsKey(str.charAt(right))){
                    map.put(str.charAt(left),map.get(str.charAt(left))-1);

                    if(map.get(str.charAt(left))==0){
                        map.remove(str.charAt(left));
                    }
                    left++;
                }
            
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);

            answer = Math.max(answer,(right-left)+1);
        }
        return answer;
    }
}