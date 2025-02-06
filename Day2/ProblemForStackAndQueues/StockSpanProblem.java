package Day2.ProblemForHashMapAndFunctions.ProblemForStackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static ArrayList<Integer> calculateCount(ArrayList<Integer> arr){
        ArrayList<Integer> al= new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< arr.size(); i++){
            while(!st.isEmpty() && arr.get(st.peek()) <=arr.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                al.add(i+1);
            }
            else{
                al.add(i-st.peek());
            }
            st.push(i);
        }
        return al;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(100,80,60,70,65,75,85));
        ArrayList<Integer> finalArray = calculateCount(arr);
        for(int count : finalArray){
            System.out.print(count + " ");
        }

    }
}
