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

        for (int i =0; i<arr.length;i++){
            System.out.printf("%d", arr[i]);
        }
 

        return j;
        
    }
    
}