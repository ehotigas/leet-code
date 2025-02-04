public class Problem4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        int targetidx = (nums1.length + nums2.length) / 2;
        double median = 0;
        
        for (int num1Idx = 0, num2Idx = 0; num1Idx + num2Idx <= targetidx;) {
            double number1 = Double.POSITIVE_INFINITY;
            if (num1Idx < nums1.length) number1 = nums1[num1Idx];
            double number2 = Double.POSITIVE_INFINITY;
            if (num2Idx < nums2.length) number2 = nums2[num2Idx];
            if ((!isOdd && num1Idx + num2Idx == targetidx - 1) || (num1Idx + num2Idx == targetidx)) {
                median += Double.min(number1, number2);
            }
            if (number1 > number2) {
                num2Idx++;
                continue;
            }
            num1Idx++;
        }
        return isOdd ? median : median / 2;
    }

    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println("Resultado: " + result);
    }
}
