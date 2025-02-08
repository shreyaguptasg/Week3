package Day6.SerachTargetInLargeDataset;
public class SearchTarget {
    public static void linearSerach(int[] arr, int target){
        long startTime = System.nanoTime();
    boolean  flag = false;
    for(int i=0; i<arr.length; i++){
        if(arr[i]==target) {
            System.out.println("target number " + target + " was found");
            flag = true;
            break;
        }

    }
    if(!flag){
        System.out.println("target was not found");
    }
        long endTime = System.nanoTime();
        System.out.println("linear search time " + (endTime-startTime));
}
    public static void binarySerach(int[] arr, int target,int start, int end){
        long startTime = System.nanoTime();
            while(start<=end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    System.out.println("target was found");
                    long endTime = System.nanoTime();
                    System.out.println("binary search time " + (endTime-startTime));
                    return;
                    } else if (arr[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
            }
    }

    public static void main(String[] args) {
        int [] arr = new int[1000];
        for(int i=0; i<1000; i++){
            arr[i]= i;
        }
        int target = 450;
        linearSerach(arr, target);
        binarySerach(arr,target,0,arr.length-1);
    }
}
