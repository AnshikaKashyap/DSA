package TwoPointers;

import java.util.Arrays;

/*We have been given an integer ‘B’ and a sorted array Arr[N] containing ‘N’ distinct elements. We have to find the number of rectangles (l, b) with distinct configurations that can be formed using array elements such that Area<B.

Input: Arr[3] = {2, 3, 5}. B=15

Output: 6      {(2, 2), (2, 3), (2, 5), (3, 2), (3, 3), (5, 2)*/
public class DistinctRectangles {
    public static void main(String []args)
    {
        int[] arr = {2,3,5};
        int B = 15;
        distinctRectCount(arr,B);
    }

    static void distinctRectCount(int[] arr, int area)
    {
        int count = 0;
        int i =0;
        int j = arr.length -1;
        while(i<=j)
        {
            int curr_area = arr[i]*arr[j];
            if(curr_area < area)
            {
                count = count+(2*(j-i+1)-1);
                i++;
            }
            else if(curr_area >= area)
            {
               j--;
            }
        }
        System.out.println("count is: "+count);
    }
}
