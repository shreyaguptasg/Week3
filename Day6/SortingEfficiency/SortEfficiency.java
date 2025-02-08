package Day6.SortingEfficiency;

import java.util.Arrays;

public class SortEfficiency {

    public static void bubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        boolean flag;

        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        long endTime = System.nanoTime();
        System.out.println("Bubble Sort time: " + (endTime - startTime) + " nanoseconds");
    }

    public static void mergeSort(int[] arr) {
        long startTime = System.nanoTime();
        mergeSortHelper(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Merge Sort time: " + (endTime - startTime) + " nanoseconds");
    }

    private static void mergeSortHelper(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSortHelper(arr, start, mid);
            mergeSortHelper(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] merge = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                merge[k++] = arr[i++];
            } else {
                merge[k++] = arr[j++];
            }
        }

        while (i <= mid) merge[k++] = arr[i++];
        while (j <= end) merge[k++] = arr[j++];

        System.arraycopy(merge, 0, arr, start, merge.length);
    }

    public static void quickSort(int[] arr) {
        long startTime = System.nanoTime();
        quickSortHelper(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Quick Sort time: " + (endTime - startTime) + " nanoseconds");
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 100, 99, 67, 23, 45};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        bubbleSort(arr1);
        System.out.println("Bubble Sorted Array: " + Arrays.toString(arr1));

        mergeSort(arr2);
        System.out.println("Merge Sorted Array: " + Arrays.toString(arr2));

        quickSort(arr3);
        System.out.println("Quick Sorted Array: " + Arrays.toString(arr3));
    }
}
