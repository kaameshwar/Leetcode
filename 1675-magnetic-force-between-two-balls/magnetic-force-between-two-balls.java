class Solution {
    boolean CanBePlaced(int [] position , int m, int pointer){
        int balls_placed =1;
        int last_placed =0;
        for (int i =1; i<position.length;i++){
            if(position[i] - position[last_placed] >=pointer){
                balls_placed++;
                last_placed =i;
            }
        }
        if(balls_placed>=m) return true;
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];
        int result = Integer.MIN_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(CanBePlaced(position, m, mid) == true){
                result = Math.max(result, mid);
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
}