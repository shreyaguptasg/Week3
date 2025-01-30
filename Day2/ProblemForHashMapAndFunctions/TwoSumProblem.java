package Day2.ProblemForHashMapAndFunctions;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumProblem {
    public static ArrayList<Integer> findTwoSum(int [] arr, int sum){
        int n = arr.length;
        HashMap<Integer,Integer> mpp= new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int rem = arr[i];
            int more= sum - rem;
            if(mpp.containsKey(more)){
                list.add(mpp.get(more));
                list.add(i);
                return list;
            }
            mpp.put(rem, i);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        ArrayList<Integer> result = findTwoSum(nums, target);

        if (!result.isEmpty()) {
            System.out.println("Indices: " + result);
        } else {
            System.out.println("No solution found.");
        }
    }
}
