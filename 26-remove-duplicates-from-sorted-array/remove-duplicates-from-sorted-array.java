class Solution {
    public int removeDuplicates(int[] arr) {
        int j =1;

        for (int i =1; i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                continue;
            }
            else if(arr[i]!=arr[i-1]){
                arr[j++]=arr[i];
            }


        }
        int i =0;
        while(i<arr.length){
            System.out.printf("%d", arr[i]);
            i++;
        }
        
 

        return j;
        
    }
    
}