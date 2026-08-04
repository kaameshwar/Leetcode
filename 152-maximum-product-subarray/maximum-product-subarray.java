class Solution {
    public int maxProduct(int[] nums) {
        int max_prod =Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        int n = nums.length;
        for (int pointer =0; pointer<n;pointer++){

            //calculating the prefix and suffix 
            prefix *= nums[pointer];
            suffix*= nums[n-pointer-1];
            //comparing those 3 values to get the maximum of them..
            max_prod= Math.max(max_prod, Math.max(prefix,suffix));
            //if zero comes we should be able to recover from it for the next operations right??, so we make which ever needed to be changed..
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;

        }
        return max_prod;
    }
}