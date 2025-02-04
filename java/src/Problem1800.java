public class Problem1800 {
    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int tmpSum = 0;
        int lastNumber = -1;
        for (int numsIdx = 0; numsIdx < nums.length; numsIdx++) {
            if (nums[numsIdx] <= lastNumber) {
                tmpSum = nums[numsIdx];
            }
            else {
                tmpSum += nums[numsIdx];
            }
            if (maxSum < tmpSum) {
                maxSum = tmpSum;
            }
            lastNumber = nums[numsIdx];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{3,6,10,1,8,9,9,8,9}));
    }
}
