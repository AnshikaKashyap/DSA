package Sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main (String[] args)
    {
            int []arr = {4,1,3,9,7};
        quickSort(arr,0,4);

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

    static int partition (int[] arr,int i, int j)
    {
        int pivot = arr[i];

        List<Integer> left_list = new ArrayList<>();
        List<Integer> right_list = new ArrayList<>();
        int cnt = 0;
        for(int l = 0; l<arr.length; l++ )
        {
            if(arr[l] <= pivot)
            {
                cnt++;
            }

        }

        // swap arr[i] and arr[cnt -1];
        int temp = arr[i];
        arr[i] = arr[cnt -1];
        arr[cnt -1] = temp;

        System.out.println("temp is: "+ arr[cnt -1]);

        for(int k= 0; k< arr.length; k++)
        {
            if(arr[k] < pivot)
            {
                left_list.add(arr[k]);
            }

            if(arr[k] > pivot)
            {
                right_list.add(arr[k]);
            }

            for(int l = 0; l<left_list.size(); l++ )
            {
                arr[l] = left_list.get(l);

            }

            for(int l = 0; l<right_list.size(); l++ )
            {
                arr[cnt+l] = right_list.get(l);

            }

        }
        System.out.println();
        for(int k= 0; k< arr.length; k++)
        {
            System.out.print(arr[k]+" ");
        }

        return (cnt -1);
    }
}
