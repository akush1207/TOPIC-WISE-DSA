package Array.PrefixSums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by commas (,):");
        int [] nums = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("Enter k:");
        int k=sc.nextInt();
        System.out.println("Subarray sum equals "+k+" : "+subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int currSum=0, count=0;
        for(int num:nums){
            currSum+=num;
            if(prefixSum.containsKey(currSum-k)){
                count+=prefixSum.get(currSum-k);
            }
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
