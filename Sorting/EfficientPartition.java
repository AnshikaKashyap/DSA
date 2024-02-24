package Sorting;

import java.util.ArrayList;
import java.util.List;

public class EfficientPartition {
    public static void main (String[] args)
    {
        int []arr = {4,1,3,9,7};
        quickSort(arr,0,4);
        for(int i = 0; i< arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
    static void quickSort(int[]arr,int i, int j)
    {
        if(i< j)
        {
            int p = partition(arr,i,j);
            quickSort(arr,i, p-1);
            quickSort(arr,p+1,j);
        }
    }

    static int partition (int[] arr,int i, int j) {
            int l = i+1;
            int r = j;
            while(l<=r) {
                while (l <= j && arr[l] <= arr[i]) {
                    l++;
                }

                while (r > i && arr[r] > arr[i]) {
                    r--;
                }

                if (l < r) {
                    // swap arr[l] and arr[r]
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                }
            }
            // swap arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
return r;
    }
}
