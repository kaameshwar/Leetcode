class Solution {
    int decision (int [] array , int m, int k, int day){
        int n = array.length;
        int counter =0;
        int boquet_count=0;
        for (int pointer=0; pointer<n;pointer++){
            if(array[pointer]<=day){
                counter++;
            }
            else{
                boquet_count += counter/k;
                counter=0;
            }

        }
        boquet_count +=counter/k;
        
        return boquet_count;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long longg=(long)m*k;
        if(longg>bloomDay.length) return -1;
        int min_number=Integer.MAX_VALUE;
        int max_number=Integer.MIN_VALUE;
        int n = bloomDay.length;
        for (int i =0 ; i<n;i++){
            min_number = Math.min(min_number , bloomDay[i]);
            max_number = Math.max(max_number, bloomDay[i]);
        }
        int left =min_number;
        int right = max_number;
        while(left<=right){
            int mid = left+(right -left)/2;
            if(decision(bloomDay,m,k,mid)>=m){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}