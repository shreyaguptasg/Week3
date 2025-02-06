package Day2.ProblemForHashMapAndFunctions.ProblemForStackAndQueues;

import java.util.ArrayList;

public class SlidingWindowMaximum {
    public static ArrayList<Integer> maxiumElementThroughWindow(int [] arr , int k){
        ArrayList<Integer> al = new ArrayList<>();
        int max;
        for(int i=0; i<=arr.length-k; i++){
            max= arr[i];
            for(int j=0; j<k; j++){
                if(arr[i+j]>max){
                    max= arr[i+j];
                }
            }
            al.add(max);
        }
        return al;
    }
    public static void main(String[] args) {
        int [] arr = {2,4,7,9,1,4,10,7};
        int k = 3;
        ArrayList<Integer> ans= maxiumElementThroughWindow(arr,k);
        for(int count : ans){
            System.out.print(count + " ");
        }

    }
}
