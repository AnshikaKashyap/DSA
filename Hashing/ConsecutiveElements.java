package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N]. We have to return true if it contains consecutive elements otherwise false.
Input: Arr[5] = {13, 16, 12, 15, 14}
Output: True
Input: Arr[5] = {5, 3, 2, 1, 4}
Output: True
Input: Arr[6] = {7, 6, 4, 4, 3, 4}
Output: False //Two 5s are there*/
public class ConsecutiveElements {
    public static void main(String[] args) {
        long[] arr1 = {13, 16, 12, 15, 14};
        long[] arr2 = {5, 3, 2, 1, 4};
        long[] arr3 = {7, 6, 4, 4, 3, 4};
        System.out.println(isConsecutiveArray(arr1));
        System.out.println(isConsecutiveArray(arr2));
        System.out.println(isConsecutiveArray(arr3));

    }
    static boolean isConsecutiveArray(long[] arr)
    {
        HashMap<Long,Integer> map = new HashMap<>();
        // find min element
        long min = Long.MAX_VALUE;
        for(int i=0; i< arr.length; i++)
        {
           min = Math.min(min,arr[i]);
           map.put(arr[i],1);
 }
        // iterate through map to check if consecutive elements exists
        for(long i= min; i< min+arr.length; i++)
        {
            if(map.get(i) == null)
            {
                return false;
            }
        }
        return true;
        }
}
