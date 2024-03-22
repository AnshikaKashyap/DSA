package BitManipulation;

import java.util.Arrays;

/*We have been given an integer array Arr[N]. Find the minimum value of Arr[i]^Arr[j], i≠j. */
public class FindMinimumXOR {
    public static void main (String[] args)
    {
        int[] arr = {2,1,4};
        findBitwiseOrOfSubarrays(arr);
    }

    static long findBitwiseOrOfSubarrays(int[] arr)
    {
        Arrays.sort(arr);
        long ans = Integer.MAX_VALUE;
        for(int i=0; i< arr.length-1; i++)
        {
            ans = Math.min(ans,(arr[i]^arr[i+1]));
        }
        System.out.println(+ans);
        return ans;
    }

}
