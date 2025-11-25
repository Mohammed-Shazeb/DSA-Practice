package Heap;

import java.util.*;

public class HeapSort {
    static class heap{
        
    }
    private static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxidx = i;

        if (left < size && arr[maxidx] < arr[left]) {
            maxidx = left;
        }
        if (right < size && arr[maxidx] < arr[right]) {
            maxidx = right;
        }

        if (maxidx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxidx];
            arr[maxidx] = temp;
            heapify(arr, maxidx, size);
        }
    }
    public static void heapSort(int arr[]){
        // build maxheap
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        // swap and heapify
        for(int i=n-1; i>0; i--){
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        // HeapSort h = new HeapSort();
        int arr[] = {1,2,4,5,3,6};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}