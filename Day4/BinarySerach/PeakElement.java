package Day4.BinarySerach;

public class PeakElement {
    public static int peakElement(int [] arr){
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return arr[mid];
            }
            else if(arr[mid]<arr[mid-1]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr= {3,4,5,-1,0,1,7,2};
        System.out.println(peakElement(arr));
    }
}
