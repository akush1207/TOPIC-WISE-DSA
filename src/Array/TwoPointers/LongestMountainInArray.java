package Array.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class LongestMountainInArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array elements separated by comma(,):");
        int[] arr = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Longest Mountain:" + longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {
        int maxLen = 0;
        int len = arr.length;
        for (int i = 1; i < len - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                while (right < len - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }

}
