package BitManipulation;
/* We have been given an integer array Arr[N] where every element comes twice except two elements which come only once. Find the two elements n1 & n2.

Input: Arr[8] = {4, 7, 9, 7, 5, 4, 3, 3}
Output:  9, 5*/
public class FindTwoElements {
    public static void main (String[] args)
    {
       int[] arr = {4, 7, 9, 7, 5, 4, 3, 3};
        findTwoSingleElements(arr);
    }
    static void findTwoSingleElements(int[] arr)
    {
        // first get xor of all alements of array
        long xor_sum = 0;
        for(int i=0; i<arr.length; i++)
        {
            xor_sum = xor_sum^arr[i];
        }
        // get most significant bit of array
        int msb = 1;
        while((msb & xor_sum) == 0) {
            msb = msb << 1;
        }
        // create two categories of elements
        int val1 = 0;
        for(int i=0; i< arr.length; i++)
        {
            if((arr[i] & msb) != 0)
                val1 = val1 ^ arr[i];
        }
        System.out.println("value 1: "+val1);
        System.out.println("value 2: "+(val1^xor_sum));
    }
}
