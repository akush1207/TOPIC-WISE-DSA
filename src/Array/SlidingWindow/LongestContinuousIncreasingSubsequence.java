package Array.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] nums = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("LCIS : " + findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 1;
            }
        }
        maxLength = Math.max(maxLength, count);
        return maxLength;
    }

}
