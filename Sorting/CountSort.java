package Sorting;

public class CountSort {

    public static void main (String[] args)
    {
        int []arr = {0,1,0,3,12};
        int[] freq = {2,1,0,1,0,0,0,0,0,0,0,0,1};
        int[]   cf = {2,3,3,4,4,4,4,4,4,4,4,4,5};
        int[] ans = new int[arr.length];
        ans = countSortImpl(arr);
        for(int i =0; i< ans.length; i++)
        {
            System.out.print(ans[i]+ " ");
        }

    }

    static int[] countSortImpl(int[] arr){
        // find max and min element
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i< arr.length; i++)
        {
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        System.out.println("max and min: "+ max+" "+min);

        int[] freq = new int[max-min+1];
        // update freq array
        for(int i=0; i< arr.length; i++)
        {
          freq[arr[i] - min]++;
        }
        // create cumulative freq array
        for(int i=1; i<=(max-min); i++)
        {
            freq[i] = freq[i]+ freq[i-1];
        }

        // iterate over original array and place elements as per frequencies
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--)
        {
           ans[freq[arr[i]-min]-1] = arr[i];
            freq[arr[i]-min] --;
        }
    return ans;
    }
}
