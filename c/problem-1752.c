#include <stdio.h>

int check(int* nums, int numsSize) {
    if (numsSize <= 2) return 1;
    int decreasingCount = 0;
    int lastNumber = nums[numsSize - 1];
    for (int numsIdx = 0; numsIdx < numsSize; numsIdx++) {
        if (nums[numsIdx] < lastNumber) decreasingCount++;
        if (decreasingCount > 1) return 0;
        lastNumber = nums[numsIdx];
    }
    return 1;
}

int main(void) {
    int nums[] = { 2,1,3,4 };
    int result = check(nums, 5);
    printf("Result: %d", result);
    return 0;
}