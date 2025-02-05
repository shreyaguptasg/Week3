package Day4.LinearSerach;
//. Write a program that performs Linear Search to find the first negative number in the array.
public class SearchFirstNegativeNumber {
    public static int searchFIrstNegativeNumber(int [] arr){
        //If a negative number is found, return its index.
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                return i;
            }
        }
        //. If no negative number is found, return -1.
        return -1;
    }
    public static void main(String[] args) {
        int [] arr= {1,2,3,5,100,9,7,-2};
        System.out.println(searchFIrstNegativeNumber(arr));
    }
}
