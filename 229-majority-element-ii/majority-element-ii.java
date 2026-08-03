class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int number1 = 0;
        int number2 = 0;
        int count1 = 0, count2 = 0;

        for (int value : nums) {
            if (count1 > 0 && value == number1) {
                count1++;
            } else if (count2 > 0 && value == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = value;
                count1++;
            } else if (count2 == 0) {
                number2 = value;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int value : nums) {
            if (value == number1) {
                count1++;
            } else if (value == number2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            result.add(number1);
        }

        if (count2 > n / 3) {
            result.add(number2);
        }

        return result;
    }
}