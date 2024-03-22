package BitManipulation;
/*We have been given an integer array Arr[N] and we have to process Q queries of the form [i, j].
For every query we have to find the XOR of elements from index i to j.
 Precomputation/Calculating prefix XOR- Since we know that:

    x^x = 0
    0^x = x

    Therefore, lets say we nee xor of [2,4] then this should be equal to prefix XOR[4] ^ prefix XOR[1]
   as (1^2^3^4)^ 1= 2^3^4 */

public class MultipleXORQueries {
    public static void main(String[] args) {
        {
            int[] arr = {1, 3, 4, 8};
            int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
            findQueryOutput(arr,queries);
        }


    }

    private static void findQueryOutput(int[] arr, int[][] queries) {
        int[] pxor = new int[arr.length];
        pxor[0] = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            pxor[i] = (arr[i] ^ pxor[i-1]) ;
        }
        for(int i=0; i< queries.length; i++)
        {
            if(queries[i][0] == 0)
                System.out.println( pxor[queries[i][1]]);
            else
                System.out.println( pxor[queries[i][0]-1]^pxor[queries[i][1]]);
        }
    }
}
