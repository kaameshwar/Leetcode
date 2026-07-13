class Solution {
    public int reverse(int x) {
        int y =x;
        int count = 0;
        int finall=0;
        if(x==0) count=1;
        else if(x>=Integer.MAX_VALUE || x<=Integer.MIN_VALUE) return 0;
        while(x!=0){
            count++;
            x/=10;
            
        }

        while(y!=0){
            int digit = y%10;
            finall += (int)digit*Math.pow(10, count-1);
            count--;
            y = y/10;

        }
        if(finall>=Integer.MAX_VALUE || finall<=Integer.MIN_VALUE) return 0;
        
        return finall;

    }
}