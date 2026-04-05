package Array.MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IntervalListIntersections {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the firstList:");
        int len1 = sc.nextInt();
        int[][] firstList = new int[len1][2];
        System.out.println("Enter firstList intervals");
        for (int i = 0; i < len1; i++) {
            System.out.print("Enter interval " + (i + 1) + " : ");
            firstList[i][0] = sc.nextInt();
            firstList[i][1] = sc.nextInt();
        }
        System.out.println("Enter the length of the secondList:");
        int len2 = sc.nextInt();
        int[][] secondList = new int[len2][2];
        System.out.println("Enter secondList intervals");
        for (int i = 0; i < len2; i++) {
            System.out.print("Enter interval " + (i + 1) + " : ");
            secondList[i][0] = sc.nextInt();
            secondList[i][1] = sc.nextInt();
        }
        System.out.println("Interval Intersection:" + Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                result.add(new int[]{start, end});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}
