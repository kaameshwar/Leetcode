class Solution {
    public boolean isAnagram(String str1, String str2) {
        int []frequency = new int [26];
        if (str1.length()!= str2.length()) return false;

        for (int pointer =0 ; pointer< str1.length(); pointer++){
            frequency[str1.charAt(pointer)- 'a']++;
            frequency[str2.charAt(pointer)- 'a']--;

        }
        for (int number : frequency){
            if(number!=0) return false;
        }
        return true;
    }
}