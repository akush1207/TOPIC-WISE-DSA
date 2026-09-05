package Array.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array elements separated by commas (,):");
        int[] nums = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("Enter k:");
        int k = sc.nextInt();
        System.out.println("numSubarrayProductLessThanK:" + numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int left = 0, right;
        long prod = 1;
        for (right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
