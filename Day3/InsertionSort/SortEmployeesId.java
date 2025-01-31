package Day3.InsertionSort;

import java.util.Arrays;

public class SortEmployeesId {
    public static void insertionSort(int [] employeeId){
        int n = employeeId.length;
        for(int i=1; i<n; i++){
            int temp= employeeId[i];
            int j = i-1;
            while(j>=0 && employeeId[j]>temp){
                employeeId[j+1]= employeeId[j];
                j--;
            }
            employeeId[j+1]= temp;

        }
    }
    public static void main(String[] args) {
        int [] employeeId = {78,90,2,4,10};
        insertionSort(employeeId);
        System.out.println(Arrays.toString(employeeId));
    }
}
