package Day3.QuickSort;

import java.util.Arrays;

public class SortProductPrize {
    public static void quickSort(int [] productPrize, int low, int high){
        if(low<high){
            int pi = parition(productPrize,low,high);
            quickSort(productPrize, low, pi-1);
            quickSort(productPrize, pi, high);
        }
    }
    private static int parition(int [] arr, int low, int high){
        int pivot =  arr[high];
        int i = low-1;
        for(int j = low; j<high;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i]= pivot;
        arr[high]= temp;
        return i;

    }
    public static void main(String[] args) {
        int [] productPrize = {78,90,2,4,10};
        quickSort(productPrize,0,productPrize.length-1);
        System.out.println(Arrays.toString(productPrize));

    }
}
