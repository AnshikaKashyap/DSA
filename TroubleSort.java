import java.util.Arrays;

public class TroubleSort {
    public static void main (String[] args)
    {
//        troubleSortImpl(new int[]{10,11,1,7},4);
        troubleSortImpl(new int[]{4,3,2,1},4);
    }
    public static void troubleSortImpl(int[] arr, int n)
    {
        int[] tempEvenArr = new int[n/2+1];
        int[] tempOddArr = new int[n/2+1];
        int[] sortedArr = new int[n];
        // populate temp even array
        /*1--0, 3--1, 5--2, 7--3 odd
        * 0--0,2--1,4--2, 6--3*/

        for(int i=0; i<((n/2)+1); i++)
        {
            System.out.print("debug1 ");
            tempEvenArr[i] = Integer.MAX_VALUE;
            tempOddArr[i] = Integer.MAX_VALUE;
            System.out.print("debug2 ");
        }


        for(int i=0; i<n; i=i+2)
        {
            tempEvenArr[i/2] = arr[i];
        }

        for(int i=1; i<n; i=i+2)
        {
            tempOddArr[i/2] = arr[i];
        }


        Arrays.sort(tempEvenArr);
        Arrays.sort(tempOddArr);

        for(int i=0;i<((n/2)+1) && (i*2 < n);i++)
        {
            sortedArr[i*2] = tempEvenArr[i];
        }

        for(int i=0;i<(n/2+1)  && ((i*2)+1 < n);i++)
        {
            sortedArr[i*2+1] = tempOddArr[i];
        }

        for(int i=0;i<n;i++)
        {
            System.out.print(sortedArr[i]+" ");
        }
        System.out.println();

    }
}
