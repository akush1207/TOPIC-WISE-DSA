package Array.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPartition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] nums = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Maximized Sum : " + arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        int maximizedSum = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i += 2) {
            maximizedSum += nums[i];
        }
        return maximizedSum;
    }

}
