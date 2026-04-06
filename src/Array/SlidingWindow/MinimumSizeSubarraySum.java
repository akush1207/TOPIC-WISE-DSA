package Array.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] nums = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("Enter the target sum:");
        int target = sc.nextInt();
        System.out.println("Minimum Length of sub array : " + minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MIN_VALUE ? 0 : minLength;
    }
}
