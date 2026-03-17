package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma(,):");
        String arr = sc.next();
        int[] nums = Arrays.stream(arr.split(","))
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Number of unique elements are: " + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int ind = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[ind - 1] != nums[i]) {
                nums[ind++] = nums[i];
            }
        }
        return ind;
    }

}
