package Sorting;
/*We have been given an integer array Arr[N], such that Arr[i] ∈ [0, N^2-1]. We have to sort the array in O(k*N) time complexity where k is as small as possible. */
/*To implement linear sort we will implement radix sort for base N. This way complexity will come down to linear time */
public class LinearTimeSorting {
    public static void main (String[] args)
    {
        int []arr = {6,5,4,3,2,1,0};

        System.out.println();
        int[] ans;
        ans = linearSortImpl(arr);
        System.out.println();
        for(int i =0; i< ans.length; i++)
        {
            System.out.print(ans[i]+ " ");
        }

    }
    static int[] linearSortImpl(int[] arr){

        int max = Integer.MIN_VALUE;
        int[] ans = new int[arr.length];
        int[] temp = new int[arr.length];
        for(int i=0; i< arr.length; i++)
        {
            temp[i] = arr[i];
        }

        for(int k=0; k<2; k++) {
            int[] freq = new int[10];
            // update freq array
            for (int i = 0; i < temp.length; i++) {
                double d = Math.pow(arr.length, k);
                freq[(temp[i] / (int) Math.round(d)) % arr.length]++;
            }

            // create cumulative freq array
            for (int i = 1; i < 10; i++) {
                freq[i] = freq[i] + freq[i - 1];
            }

            // iterate over original array and place elements as per frequencies

            for (int i = ans.length - 1; i >= 0; i--) {
                double d = Math.pow(arr.length, k);
                ans[freq[(temp[i]/(int) Math.round(d)) % arr.length] - 1] = temp[i];
                freq[(temp[i]/(int) Math.round(d)) % arr.length]--;
            }
            // copy contents of ans array to temp array
            System.out.println();
            for(int i=0; i< ans.length; i++)
            {
                temp[i] = ans[i];
            }
        }
        return ans;
    }
}
