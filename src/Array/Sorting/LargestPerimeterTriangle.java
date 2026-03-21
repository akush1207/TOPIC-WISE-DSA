package Array.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] nums = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Largest Perimeter : " + largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < (nums[i - 1] + nums[i - 2])) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }


}
