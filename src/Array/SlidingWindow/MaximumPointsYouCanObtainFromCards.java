package Array.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the points elements separated by commas(,):");
        int[] cardPoints = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("Enter k:");
        int k = sc.nextInt();
        System.out.println("Max Score:" + maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int totalSum = 0;
        for (int num : cardPoints) {
            totalSum += num;
        }

        if (k == n) return totalSum;

        int windowSize = n - k;

        int windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];

            minSum = Math.min(minSum, windowSum);
        }

        return totalSum - minSum;
    }

}
