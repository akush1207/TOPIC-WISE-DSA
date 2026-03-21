package Array.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] nums = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Maximum Product:" + maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int prod1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int prod2 = nums[0] * nums[1] * nums[len - 1];
        return Math.max(prod1, prod2);
    }

}
