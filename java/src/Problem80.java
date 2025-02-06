public class Problem80 {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int lastNumber = 0;
        int numberCounter = 0;
        for (int numsIdx = 0; numsIdx < nums.length; numsIdx++) {
            if ((lastNumber != nums[numsIdx]) || (lastNumber == nums[numsIdx] && numberCounter == 1) || numsIdx == 0) {
                if (lastNumber != nums[numsIdx]) numberCounter = 0;
                nums[k] = nums[numsIdx];
                k++;
                numberCounter++;
            }
            lastNumber = nums[numsIdx];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
