package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma(,):");
        String arr = sc.next();
        int[] nums = Arrays.stream(arr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Sorted Squares: " + Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int left = 0, right = len - 1;
        int ind = len - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (rightSquare > leftSquare) {
                ans[ind--] = rightSquare;
                right--;
            } else {
                ans[ind--] = leftSquare;
                left++;
            }
        }
        return ans;
    }
}
