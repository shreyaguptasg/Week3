package Day4.BinarySerach;

public class SerachTargetINSortedMatrix {
    public static boolean searchTarget(int [][] arr, int target){
        int rows= arr.length;
        int columns = arr[0].length-1;
        //Initialize left as 0 and right as rows * columns - 1.
       int left = 0;
       int right = rows*columns-1;
       while(left<=right){
           int mid= left + (right - left)/2;
           //Convert mid to row and column indices using
           // row = mid / numColumns and
           // col = mid % numColumns.
           int arrRow = mid/columns;
           int arrCol = mid%columns;
           //Compare the middle element with the target:
           //If it matches, return true.
           //If the target is smaller, search the left half by updating right = mid - 1.
           //If the target is larger, search the right half by updating left = mid + 1.
           if(arr[arrRow][arrCol]== target){
               return true;
           }
           else if(arr[arrRow][arrCol]>target){
              right = mid-1;
           }
           else{
               left = mid+1;
           }
       }
       //If the element is not found, return false.
        return false;
    }
    public static void main(String[] args) {
        int [][] arr= {{1,2,3,4},
                      {5,6,7,8}};
        int target = 5;
        System.out.println(searchTarget(arr, target));
    }
}
