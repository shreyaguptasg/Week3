package Day2.ProblemForHashMapAndFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllSubarrayswithZeroSum {
    public static void findZeroSumSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        // Store results
        List<int[]> result = new ArrayList<>();

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If this sum has been seen before, all subarrays ending at 'i' are zero-sum
            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIdx : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{startIdx + 1, i}); // Store subarray indices
                }
            }

            // Store current cumulative sum index
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        // Print results
        if (result.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (int[] subarray : result) {
                System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
}


