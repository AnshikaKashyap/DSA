package Sorting;

public class RadixSort {

    public static void main (String[] args)
    {
        int []arr = {6,5,4,3,2,1,0};

        System.out.println();
        int[] ans;
        ans = radixSortImpl(arr);
        System.out.println();
        for(int i =0; i< ans.length; i++)
        {
            System.out.print(ans[i]+ " ");
        }

    }
    static int[] radixSortImpl(int[] arr){

        int max = Integer.MIN_VALUE;
        int[] ans = new int[arr.length];
        int[] temp = new int[arr.length];
        for(int i=0; i< arr.length; i++)
        {
            if(arr[i] > max) max = arr[i];
            temp[i] = arr[i];
        }
        int numDigits = String.valueOf(max).length();
        for(int k=0; k<numDigits; k++) {
            int[] freq = new int[10];
            // update freq array
            for (int i = 0; i < temp.length; i++) {
                double d = Math.pow(10, k);
                freq[(temp[i] / (int) Math.round(d)) % 10]++;
            }

            // create cumulative freq array
            for (int i = 1; i < 10; i++) {
                freq[i] = freq[i] + freq[i - 1];
            }

            // iterate over original array and place elements as per frequencies

            for (int i = ans.length - 1; i >= 0; i--) {
                double d = Math.pow(10, k);
                ans[freq[(temp[i]/(int) Math.round(d)) % 10] - 1] = temp[i];
                freq[(temp[i]/(int) Math.round(d)) % 10]--;
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
