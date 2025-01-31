package Day3.SelectionSort;

import java.util.Arrays;

public class SortExamScore {
    public static void selectionSort(int [] arr){
        for(int i=0; i<arr.length;i++){
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, 0, last);
            int temp = arr[maxIndex];
            arr[maxIndex]= arr[last];
            arr[last] = temp;
        }
    }
    public static int getMaxIndex(int [] arr, int start, int end){
       int max= start;
        for(int i=start; i<=end; i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] examScore = {78,90,2,4,10};
        selectionSort(examScore);
        System.out.println(Arrays.toString(examScore));
    }
}
