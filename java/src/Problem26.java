public class Problem26 {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int previous = 0;
        for (int numsIdx = 0; numsIdx < nums.length; numsIdx++) {
            if (nums[numsIdx] != previous || numsIdx == 0) {
                nums[k] = nums[numsIdx];
                k++;
            }
            previous = nums[numsIdx];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
