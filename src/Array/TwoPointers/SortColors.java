package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class SortColors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array elements separated by comma(,):");
        String arr = sc.next();
        int[] nums = Arrays.stream(arr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        sortColors(nums);
        System.out.println("Sorted Colors: " + Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
