class Solution {
    public int mySqrt(int x) {
        if (x<2)return x;
        int left = 1;
        int right = x-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            long rooter = (long)mid*mid;
            if(rooter == x){
                return mid;
            }
            else if(rooter>x){
                right = mid-1;
            }
            else{
                left = mid+1;
            }

        }
        return right;
    }
}