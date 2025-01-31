package Day3.MergeSort;

import java.util.Arrays;

public class SortArrayOfBookPrice {
    public static void mergeSort(int [] bookPrice, int lb, int ub){
        if(lb<ub){
            int mid = lb + (ub -lb)/2;
            mergeSort(bookPrice, lb, mid);
            mergeSort(bookPrice, mid+1, ub);
            merge(bookPrice, lb, mid, ub);
        }
    }
    private static void merge(int [] bookPrice, int lb, int mid, int ub) {
        int i= lb;
        int j = mid +1;
        int k = 0;
        int [] merge = new int[ub-lb+1];
        while(i<=mid && j<=ub){
            if(bookPrice[i]<=bookPrice[j]){
                merge[k]= bookPrice[i];
                i++;
            }
            else{
                merge[k]= bookPrice[j];
                j++;
            }
            k++;
        }
        if(i>mid){
            while(j<=ub){
                merge[k]= bookPrice[j];
                j++;
                k++;

            }
        }
        else{
            while(i<=mid){
                merge[k]= bookPrice[i];
                i++;
                k++;
            }
        }
        for(int x=0; x< merge.length; x++){
            bookPrice[lb+x] = merge[x];
        }
    }

    public static void main(String[] args) {
        int [] bookPrice = {78,90,2,4,10};
        mergeSort(bookPrice, 0, 4);
        System.out.println(Arrays.toString(bookPrice));
    }

}
