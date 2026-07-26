class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int count =0;
        int [] sieve = new int [n];
        for (int i =0; i<sieve.length;i++){
            sieve[i]=1;
        }
        for (int pointer =2; pointer*pointer<sieve.length;pointer++){
            if(sieve[pointer]!=0){
                for (int j= pointer*pointer;j<sieve.length; j+=pointer){
                    sieve[j]=0;
                }
            }

        }
        for (int pointer =2; pointer<sieve.length;pointer++){
            if(sieve[pointer]==1) count++;
        }
        return count;
    }
}