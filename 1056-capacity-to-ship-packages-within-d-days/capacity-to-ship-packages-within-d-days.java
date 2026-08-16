class Solution {
    int days_taken (int[] weights, int mid){
        int days_taken =1;
        int total =0;
        for (int weight : weights){
            if(total+weight>mid){
                days_taken++;
                total =0;
            }
            total+=weight;
        }
        return days_taken;
    }
    public int shipWithinDays(int[] weights, int days) {
        int largest_number =0;
        int total_weight =0;
        for (int i =0 ;i<weights.length; i++){
            largest_number = Math.max(largest_number, weights[i]);
            total_weight+=weights[i];

        }
        int left =largest_number;
        int right = total_weight;
        while(left<=right){
            int mid = left+(right-left)/2;
            int days_taken = days_taken(weights,mid);
            if(days_taken <=days){
                right = mid-1;

            }
            else {
                left = mid+1;
            }
            
        }
        return left;
    }
}