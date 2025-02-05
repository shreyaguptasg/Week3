package Day4.BinarySerach;

 class FirstAndLastOccurrenceInSortedArray {
   public static int firstOccurrence(int [] arr, int target){
       int left =0;
       int right = arr.length -1;
       int firstOccurence = -1;
       while(left<=right){
           int mid = left + ( right-left)/2;
           if(arr[mid]==target){
               firstOccurence= mid;
               right = mid -1;
           }
           else if(arr[mid]>target){
               left = mid+1;
           }
           else{
               right= mid -1;
           }
       }
       return  firstOccurence;
   }
    public static int lastOccurrence(int [] arr, int target){
        int left =0;
        int right = arr.length -1;
        int lastOccurence = -1;
        while(left<=right){
            int mid = left + ( right-left)/2;
            if(arr[mid]==target){
                lastOccurence= mid;
               left = mid +1;
            }
            else if(arr[mid]<target){
               left= mid +1;
            }
            else{
                right= mid -1;
            }
        }
        return  lastOccurence;
    }
    public static void main(String[] args) {
        int [] arr= {3,4,4,4,6,7,8,9};
        int target = 4;
        int [] res = new int[2];
        res[0]= firstOccurrence(arr,target);
        res[1]= lastOccurrence(arr,target);
        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }

    }
}
