package Array.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the fruits separated by commas(,):");
        int[] fruits = Arrays.stream(sc.next().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Maximum no. of fruits:" + totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
