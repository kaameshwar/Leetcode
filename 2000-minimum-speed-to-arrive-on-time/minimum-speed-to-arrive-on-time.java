class Solution {
    double time_taken (int [] dist, int mid){
        double time_taken =0;
        for(int i=0; i<dist.length-1;i++){
            time_taken +=Math.ceil((double)dist[i]/(double)mid);
        }
        time_taken+= ((double)dist[dist.length-1]/ (double)mid);
        return time_taken;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int largest =0;
        for (int i =0;i<n;i++){
            largest=Math.max(largest, dist[i]);
        }
        int left =1;
        int right = 10000000;
        while(left<=right){
            int mid = left+(right-left)/2;
            double time_taken = time_taken(dist,mid);
            if(time_taken > hour){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(left>10000000) return -1;
        return left;
    }
}