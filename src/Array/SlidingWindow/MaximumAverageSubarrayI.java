package Array.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas (,):");
        int[] nums = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("Enter k:");
        int k = sc.nextInt();
        System.out.println("findMaxAverage:" + findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        long maxSum = windowSum;

        for (int right = k; right < nums.length; right++) {
            int left = right - k;
            windowSum += nums[right] - nums[left]; // add new, remove old
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
