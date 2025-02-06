package Day2.ProblemForHashMapAndFunctions;
import java.util.*;

public class CheckPairwithGivenSumArray {
    public static void findPair(int[] arr, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists
            if (numMap.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + arr[i] + ")");
                return;
            }

            // Store the current number with its index
            numMap.put(arr[i], i);
        }

        System.out.println("No pair found.");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, 1, 8};
        int target = 9;
        findPair(arr, target);
    }
}



