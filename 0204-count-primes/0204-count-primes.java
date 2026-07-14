class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int [] array= new int[n+1];
        int count =0;

        for (int i =2;i<n;i++){
            array[i]=1;
        }
        for(int j =2;j*j<n;j++){
            if(array[j]==1){
                for(int k =j*j;k<n;k+=j){
                    array[k]=0;
                }
            }
        }
        for(int iterator =2;iterator<n;iterator++){
            if(array[iterator]==1){
                count++;
            }

        }
        return count;
    }
}