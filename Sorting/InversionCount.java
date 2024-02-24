package Sorting;

import java.util.Scanner;

public class InversionCount {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i< t; i++)
        {


            int num = sc.nextInt();
            int[] arr = new int[num];

            for(int j=0; j< num; j++)
            {
                arr[j] = sc.nextInt();
            }

            int count = mergeSort(arr,0,num-1);
            System.out.println(count);


        }

    }

    public static int mergeSort(int[] arr, int s, int e)
    {
        int count = 0;
        int m = (s+e)/2;
        if(s==e)
        {
            return 0;
        }
        // if(s<e) {
        count += mergeSort(arr, s, m);
        count += mergeSort(arr, m + 1, e);
        count += merge(arr, s, m, m + 1, e);
        // }
        return count;
    }

    public static int merge(int[] arr, int s1, int e1, int s2, int e2)
    {
        int i= s1; int j = s2;
        int c= s1; int count = 0;
        int[] temp = new int[arr.length];
        for(;i<=e1 && j<=e2;)
        {
            if(arr[i] <= arr[j])
            {
                temp[c++] = arr[i++];
            }
            else
            {
                count = count+(e1-i+1);
                temp[c++] = arr[j++];
            }
        }


        for(;i<=e1;)
        {
            temp[c++] = arr[i++];
        }
        for(;j<=e2;)
        {
            temp[c++] = arr[j++];
        }

        for(int k=s1; k<= e2; k++)
        {
            arr[k] = temp[k];
        }
        return count;
    }

}
