package Day3.CountingSort;

import java.util.Arrays;

public class SortStudentsAge {
    public static void countingSort(int [] arr){
        int max= 0;
        for(int i=0; i< arr.length; i++){
            max= Math.max(max, arr[i]);
        }
        int [] count = new int[max+1];
       for(int counter: arr){
           count[counter]++;
       }
       int index=0;
       for(int i=0; i<=max; i++){
           while(count[i]>0) {
               arr[index] = i;
               index++;
               count[i]--;
           }
       }
    }
    public static void main(String[] args) {
        int [] age= {2,9,10,45,18};
        countingSort(age);
        System.out.println(Arrays.toString(age));
    }
}
