public class Problem1752 {
    public boolean checkArray(int[] nums, int xRotate) {
        if (nums.length == 0) return true;
        int lastNumber = nums[(0 + xRotate)%nums.length];
        for (int arrayIdx = 1; arrayIdx < nums.length; arrayIdx++) {
            if (nums[(arrayIdx + xRotate)%nums.length] < lastNumber) return false;
            lastNumber = nums[(arrayIdx + xRotate)%nums.length];
        }
        System.out.println(xRotate);
        return true;
    }
    
    public boolean check(int[] nums) {
        for (int xRotate = 0; xRotate < nums.length; xRotate++) {
            if(checkArray(nums, xRotate)) {
                return true;
            }
        }
        return false;
    }

    public boolean check2(int[] nums) {
        if (nums.length <= 2) return true;
        int decreasingCount = 0;
        int lastNumber = nums[nums.length - 1];
        for (int numsIdx = 0; numsIdx < nums.length; numsIdx++) {
            if (nums[numsIdx] < lastNumber) decreasingCount++;
            if (decreasingCount > 1) return false;
            lastNumber = nums[numsIdx];
        }
        return true;
    }
}