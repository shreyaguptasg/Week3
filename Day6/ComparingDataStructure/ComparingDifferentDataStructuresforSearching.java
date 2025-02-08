package Day6.ComparingDataStructure;

import java.util.HashSet;
import java.util.TreeSet;

public class ComparingDifferentDataStructuresforSearching {
   static  long startTime, endTime ;
    public static void linearSerach(int[] arr, int target){
        startTime = System.nanoTime();
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){
                flag= true;
                break;
            }
        }
        endTime= System.nanoTime();
        System.out.println("Array Searching time : " + (endTime-startTime));
    }

    public static void hashsetSerach(int[] arr, int target){
       boolean flag= false;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< arr.length; i++){
            set.add(arr[i]);
        }
        startTime= System.nanoTime();
        if(set.contains(target)){
            flag = true;
        }
        endTime= System.nanoTime();
        System.out.println("HashSet Seraching time :" + (endTime-startTime));
    }
    public static void treeSet(int[] arr, int target){
        TreeSet<Integer> s = new TreeSet<>();
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            s.add(arr[i]);
        }
        startTime= System.nanoTime();
        if(s.contains(target)){
            flag = true;
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Searching time :" + (endTime-startTime));

    }

    public static void main(String[] args) {

        int [] arr= new int[100];
        for(int i=0; i< arr.length; i++){
            arr[i]= i;
        }
        int target = 99;
        linearSerach(arr, target);
        hashsetSerach(arr, target);
        treeSet(arr,target);

    }
}
