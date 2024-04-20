package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N] and Q queries of the form ‘x’. We have to answer true if ‘x’ is present in the array otherwise false.

Input: Arr[5] = {3, 4, 3, 5, -1}, Q=2; 5, 9
Output: True, False

*/
public class QueryProcessing1 {
    public static void main (String []args)
    {
        int[] arr = {3, 4, 3, 5, -1};
        HashMap<Integer,Integer> map = createMap(arr);
        int[] k = {5,9};
        processQuery(k,map);
    }

    static HashMap<Integer,Integer> createMap(int[] arr)
    {
        // create a map from array
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++)
        {
            map.put(arr[i], 0);
        }
        return map;



    }
    static void processQuery(int[] k, HashMap<Integer,Integer> map)
    {
        for(int i=0; i< k.length; i++)
        {
            if(map.containsKey(k[i]))
                System.out.println("True");
            else System.out.println("False");
        }
    }

}
