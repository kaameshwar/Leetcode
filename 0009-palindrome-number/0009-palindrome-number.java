class Solution {
    public boolean isPalindrome(int number) {
        int count=0;
        long result =0;
        int number_dup = number;
        int reference = number;
        if (number==0) count=1;
        while(number>0){
            count++;
            number/=10;
        }
        while(number_dup>0){
            int digit = number_dup%10;
            result += digit*Math.pow(10,count-1);
            count--;
            number_dup /=10;
        }
        if(reference == result){
            return true;
        }
        
        return false;
        
    }
}