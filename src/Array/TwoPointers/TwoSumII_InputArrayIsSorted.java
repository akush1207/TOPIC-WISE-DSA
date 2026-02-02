package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumII_InputArrayIsSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma(,):");
        String arr = sc.nextLine();
        int[] numbers = Arrays.stream(arr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("Enter the target sum:");
        int target = sc.nextInt();
        System.out.println("Indices of the target sum are: " + Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }

}
