import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memmory = new HashMap<>();
        for (int numberIdx = 0; numberIdx < nums.length; numberIdx++) {
            int complement = target - nums[numberIdx];
            if (memmory.containsKey(nums[numberIdx])) {
                return new int[]{memmory.get(nums[numberIdx]), numberIdx};
            }
            memmory.put(complement, numberIdx);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3,2,4}, 6);
        for (int number : result) {
            System.out.println(number);
        }
    }
}