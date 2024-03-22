package BitManipulation;
/*We have been given an integer array Arr[N]. Find the bitwise OR of all its subarrays.

Input: Arr[3] = {2, 1, 4}

Output: 22

Explanation: Subarray -
[2] = 2

[2, 1] = 2|1 = 3

[2, 1, 4] = 2|1|4 = 7

[1] = 1

[1, 4] = 5

[4] = 4

Sum = 2+3+7+1+5+4 = 22*/
public class BitwiseOrOfSubarrays {
    public static void main (String[] args)
    {
        int[] arr = {2,1,4};
        findBitwiseOrOfSubarrays(arr);
    }

    static long findBitwiseOrOfSubarrays(int[] arr)
    {
        long ans = 0;
        long mask = 1l <<31;
        for(int i = 31; i>=0; i--)
        {
            int next = arr.length;
            for (int j=arr.length-1; j>=0; j--)
            {
                if((arr[j] & mask) != 0)
                    next = j;
                ans = ans+(arr.length-next)*mask;

            }
            mask = mask >>1;
        }
        System.out.println(+ans);
        return ans;
    }
}
