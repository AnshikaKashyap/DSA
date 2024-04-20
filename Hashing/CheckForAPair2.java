package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N] and an integer X. We have to return True if there exists a pair with sum = X.*/
public class CheckForAPair2 {
    public static void main(String []args)
    {
        int[] arr = {4, 3, 2, 7, 1};
        int sum = 9;
        isPairExist(arr,sum);
    }

    static boolean isPairExist(int[] arr, int sum)
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< arr.length; i++)
        {
            int num = (sum - arr[i]);
           if(map.containsKey(num)) {
               System.out.println("True");
               return true;
           }
           else
           {
               // add element to map
               if(map.containsKey(arr[i]))
                   map.put(arr[i], map.get(arr[i])+1);
               else map.put(arr[i], 1);
           }

        }
        System.out.println("false");
        return false;
    }
}
