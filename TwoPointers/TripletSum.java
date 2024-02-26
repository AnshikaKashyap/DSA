package TwoPointers;

import java.util.Arrays;

/*We have been given an unsorted integer array Arr[N]. Print all the unique triplets (a, b, c) such that a+b+c=0.

Input: Arr[9] = {-5, 0, 1, 1, 2, 3, 3, 4, 4]
Output: (-5, 1, 4), (-5, 2, 3)*/
public class TripletSum {
    public static void main(String []args)
    {
        int[] arr = {-5, 0, 1, 1, 2, 3, 3, 4, 4};
        Arrays.sort(arr);
        printTriplet(arr);

    }
    static void printTriplet(int[] arr)
    {
        // b+c showul be -a for sum to be zero
        for(int i=0; i< arr.length; i++) {
            int p1 = i + 1;
            int p2 = arr.length - 1;
            while(p1 < p2){
            int sum = arr[p1] + arr[p2];
            if (sum < (-1 * arr[i])) {
                p1++;
            } else if (sum > (-1 * arr[i])) {
                p2--;
            } else if (sum == (-1 * arr[i])) {
                // print the triplets
                System.out.println(arr[i] + " " + arr[p1] + " " + arr[p2]);
                if(arr[p1] == arr[p2]) break;

                int v1 = arr[p1];
                int v2 = arr[p2];
               while(arr[p1] == v1) p1++;
               while(arr[p2] == v2) p2--;

            }
        }
        }
    }
}
