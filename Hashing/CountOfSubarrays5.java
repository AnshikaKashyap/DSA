package Hashing;
/*We have been given an integer array Arr[N]. We have to find the count total number of subarrays with sum = k.

Input: Arr[5] = {2, 1, 4, -1, 0}, k=3

Output: 3*/
import java.util.HashMap;
import java.util.Map;

public class CountOfSubarrays5 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, -1, 0};
        int k = 3;
        System.out.println(countSubarray(arr,k));

    }

    static int countSubarray(int[] arr, int sum)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i=0; i< arr.length; i++)
        {
            prefix_sum = prefix_sum+arr[i];
            if (map.containsKey(prefix_sum-sum))
            {

                ans = ans+map.get(prefix_sum-sum);

            }
            if (map.containsKey(prefix_sum)){
                map.put(prefix_sum,map.get(prefix_sum)+1);
            }
            else map.put(prefix_sum,1);
        }
//        for (Map.Entry<Integer, Integer> e : map.entrySet())
//            System.out.println("Key: " + e.getKey()
//                    + " Value: " + e.getValue());

        return ans;
    }
}
