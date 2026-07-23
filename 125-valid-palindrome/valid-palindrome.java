class Solution {
    public boolean isPalindrome(String str) {
        int left =0; 
        str= str.replaceAll("[^a-zA-Z0-9]", "");
        String str2 = str.toLowerCase();
        int right = str2.length()-1;
        while(left<=right){
            if(str2.charAt(left)!= str2.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}