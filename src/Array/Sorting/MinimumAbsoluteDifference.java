package Array.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas(,):");
        int[] arr = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Pairs with minimum Difference: " + minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(diff, minDiff);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
            }
        }

        return ans;
    }

}
