class Solution {
    int total_hours(int [] piles, int speed){
        int n = piles.length;
        int total_hours =0;
        for (int i =0; i<n;i++){
            total_hours+=Math.ceil((double)piles[i]/ (double)speed);
        }
        return total_hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int largest_number =0;
        for (int i =0 ;i<n;i++){
            largest_number = Math.max(largest_number, piles[i]);
        }
        int left =1;
        int right = largest_number;
        int hours_taken=0;
        while(left<=right){
            int mid = left+(right-left)/2;
            hours_taken = total_hours(piles, mid);

            if(hours_taken > h){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }
}