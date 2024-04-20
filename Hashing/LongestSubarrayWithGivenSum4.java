package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N] and we have to find the length of the longest subarray with sum=0.

Input: Arr[9] = {2, 1, 4, -3, -2, 3, -1, -2, 6}

Output: 7*/
public class LongestSubarrayWithGivenSum4 {
    public static void main (String []args)
    {
        int[] arr = {2, 1, 4, -3, -2, 3, -1, -2, 6};
        System.out.println(+findLongestSubarray(arr));
    }

    static int findLongestSubarray(int[] arr)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum = 0;
        map.put(0,-1);
        int ans = 0;
        for(int i=0; i< arr.length; i++)
        {
            prefix_sum = prefix_sum+arr[i];
            if(map.containsKey(prefix_sum))
                ans = Math.max(ans,(i-map.get(prefix_sum)));
            else
            {
                map.put(prefix_sum,i);
            }
        }
        return ans;
    }

}
