package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma(,):");
        String arr = sc.next();
        int[] nums = Arrays.stream(arr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Unsorted Subarray length:" + findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int startIndex = -1, endIndex = -2;
        int len = nums.length;
        int max = nums[0], min = nums[len - 1];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                endIndex = i;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                startIndex = i;
            }
        }
        return endIndex - startIndex + 1;
    }
}
