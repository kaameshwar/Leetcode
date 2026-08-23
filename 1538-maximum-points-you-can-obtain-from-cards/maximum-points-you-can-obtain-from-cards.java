class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int left = k-1;
        int right = n-1;
        int points =0;
        int max_points =0;
        
        for (int pointer=0; pointer < k ; pointer++ ){
            points += cardPoints[pointer];
        }
        max_points = Math.max(max_points, points);

        for (int pointer=0; pointer<k; pointer++ ){
            points -= cardPoints[left];
            points+= cardPoints[right];
            max_points = Math.max(max_points, points);
            left--;
            right--;
        }
        return max_points;   
    }
}