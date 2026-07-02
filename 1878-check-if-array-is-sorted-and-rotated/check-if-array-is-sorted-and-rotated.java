class Solution {
    public boolean check(int[] arr) {
        int i =0;
        int count =0;
        int n = arr.length;

        while (i <n-1){
            if(arr[i]<= arr[i+1]){
                i++;
                continue;
            }
            else{
                count++;
                i++;
            }

        }
        if(arr[n-1]>arr[0]){
            count++;
        }
        if(count==0||count==1){
            return true;
        }
        return false;
    }
}