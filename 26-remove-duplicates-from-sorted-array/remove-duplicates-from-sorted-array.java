class Solution {
    public int removeDuplicates(int[] arr) {
        int j =1;
        int i =1;

        while(i<arr.length){
            if(arr[i]==arr[i-1]){
                i++;
                continue;
            }
            else if(arr[i]!=arr[i-1]){
                arr[j++]=arr[i];
                i++;
            }


        }
        int k =0;
        while(k<arr.length){
            System.out.printf("%d", arr[k]);
            k++;
        }
        
 

        return j;
        
    }
    
}