package TwoPointers;

import java.util.Arrays;

public class QuadrupletSum {
    public static void main(String []args)
    {
        int[] arr = {-5, 0, 1, 1, 2, 3, 3, 4, 4};
        Arrays.sort(arr);
        printQuadruplet(arr);
    }
    static void printQuadruplet(int[] arr)
    {
        for(int i=0; i< arr.length; i++)
        {
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j< arr.length; j++)
            {
                if(j>0 && arr[j] == arr[j-1]) continue;
                int p1 = j + 1;
                int p2 = arr.length - 1;
                while(p1 < p2){
                    int sum = arr[p1] + arr[p2];
                    if (sum < (-1 * (arr[i]+arr[j]))) {
                        p1++;
                    } else if (sum > (-1 * (arr[i]+arr[j]))) {
                        p2--;
                    } else if (sum == (-1 * (arr[i]+arr[j]))) {
                        // print the quadruplet
                        System.out.println(arr[i] + " " +arr[j]+" "+ arr[p1] + " " + arr[p2]);
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
}
