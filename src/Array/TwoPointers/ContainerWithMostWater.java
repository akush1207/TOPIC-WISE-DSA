package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma(,):");
        String arr = sc.nextLine();
        int[] height = Arrays.stream(arr.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Maximum water in container:" + maxArea(height));

    }

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(minHeight * (right - left), maxWater);
            if (minHeight == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
