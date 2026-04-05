package Array.MergeInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of balloons:");
        int n = sc.nextInt();
        System.out.println("Enter the diameter of each balloons:");
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter diameter of balloon " + (i + 1) + " :");
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        System.out.println("Minimum no. of arrows required to burst all balloons: " + findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;

    }
}
