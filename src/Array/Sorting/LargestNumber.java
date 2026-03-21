package Array.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] nums = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Largest Number: " + largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder ans = new StringBuilder();
        for (String a : arr) {
            ans.append(a);
        }
        return ans.toString();
    }

}
