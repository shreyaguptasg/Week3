package Day4.ChallengeProblem;

import java.util.Arrays;

public class BinarySearchTargetIndex {
    public static int binarySearch(int [] arr, int target){
        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                right = mid-1;
            }
            else{
                left = mid +1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr= {0,90,8,3,24,8};
        int target = 8;
        System.out.println(binarySearch(arr, target));
    }
}
