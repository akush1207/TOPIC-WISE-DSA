package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma(,):");
        String arr = sc.next();
        int[] nums = Arrays.stream(arr.split(","))
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Remove Duplicates length: " + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int ind = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[ind - 2]) {
                nums[ind++] = nums[i];
            }
        }
        return ind;
    }
}
