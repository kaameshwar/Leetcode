class Solution {
    public boolean isAnagram(String string1, String string2) {
        int count =0;
        if(string1.length()!= string2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i =0; i<string1.length(); i++){
            char c1 = string1.charAt(i);
            char c2 = string2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
            
        }
        //for (int i =0; i<string1.length();i++){
            //char c1 = string1.charAt(i);
            //if(map1.get(c1)==map2.get(c1)){
                //count++;
            //}
        //}
        //if(count == string1.length()) return true;

        //return false;
        return map1.equals(map2);
    }
}