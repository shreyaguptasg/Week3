package Day4.BinarySerach;

public class RotationPointInRotatedSortedArray {
    public static  int rotationPoint(int [] arr){
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(arr[mid]>arr[right]){
                left = mid+1;
            }
            else if(arr[mid]<arr[left]) {
                right = mid-1;
            }else if(arr[left]<arr[right]){
                return arr[left];
            }
            else{
                return arr[right];
            }
        }
        return arr[0];
    }
    public static void main(String[] args) {
        int [] arr= {3,4,5,6,0,1,2};
        System.out.println(rotationPoint(arr));

    }
}
