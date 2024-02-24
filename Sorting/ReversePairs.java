package Sorting;

import java.util.Scanner;

/*Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

    0 <= i < j < nums.length and
    nums[i] > 2 * nums[j].
*/
public class ReversePairs {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int[] arr = {2,4,3,5,1};

        int count = mergeSort(arr,0,arr.length-1);
        System.out.println(count);
    }

    public static int mergeSort(int[] arr, int s, int e)
    {
        int count = 0;
        int m = (s+e)/2;
        if(s==e)
        {
            return 0 ;
        }

         mergeSort(arr, s, m);
          mergeSort(arr, m + 1, e);
        count += getCount(arr, s, m, m + 1, e);
         merge(arr, s, m, m + 1, e);
       return count;

    }
        public static int getCount(int[] arr, int s1, int e1, int s2, int e2)
        {
            int k= s1;int count = 0;
            for(int l=s2; l<=e2; l++)
            {
                while(k<=e1 && arr[k] < 2*arr[l]) {
                    k++;
                }
                count = count+(e1-k+1);
            }
            return count;
        }
    public static void merge(int[] arr, int s1, int e1, int s2, int e2)
    {
        int i= s1; int j = s2;
        int c= s1;
        int[] temp = new int[arr.length];

        for(;i<=e1 && j<=e2;)
        {
            if(arr[i] <= arr[j])
            {
                temp[c++] = arr[i++];
            }
            else
            {
                temp[c++] = arr[j++];
            }
        }
//        int k= s1;
//        for(int l=s2; l<=e2; l++)
//        {
//            while(k<=e1 && arr[k] < 2*arr[l])
//                k++;
//            count = count+(e1-k+1);
//        }

        for(;i<=e1;)
        {
            temp[c++] = arr[i++];
        }
        for(;j<=e2;)
        {
            temp[c++] = arr[j++];
        }

        for(int w=s1; w<= e2; w++)
        {
            arr[w] = temp[w];
        }

    }

}
