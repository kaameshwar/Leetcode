class Solution {
    int total_hours(int[] piles, int hours){
        int n = piles.length;
        int total_hours=0;
        for(int i =0; i<n;i++){
            total_hours+=Math.ceil((double)piles[i]/(double)hours);
        }
        return total_hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left =1;
        int max =0;
        for (int i=0; i<n;i++){
            max = Math.max(max, piles[i]);
        }
        int right = max;
        while(left<=right){
            int mid= left+(right-left)/2;
            int hours = total_hours(piles, mid);
            if(hours<=h){
                right= mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}