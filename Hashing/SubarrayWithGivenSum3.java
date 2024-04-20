package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N]. Return True if there is any subarray with sum = 0.

Input: Arr[5] = {6, -1, 2, 1, -1}

Output: True*/
public class SubarrayWithGivenSum3 {
    public static void main (String[] args)
    {
        int[] arr = {6, -1, 2, 2, 2};
        System.out.println(ifSubArrayExists(arr));
    }

    static boolean ifSubArrayExists(int[] arr)
    {
        int prefix_sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prefix_sum,1);
        for(int i=0; i< arr.length; i++)
        {
            prefix_sum = prefix_sum+arr[i];
            if(map.containsKey(prefix_sum))
            {
//                System.out.println("True");
                return true;
            }
            else {
                map.put(prefix_sum,1);
            }
        }
        return false;
    }
}
