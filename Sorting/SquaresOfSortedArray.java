package Sorting;

public class SquaresOfSortedArray {
    public static void main (String [] args)
    {
        int[] nums = {-7,-3,2,3,11};
        sortedSquares(nums);
    }

    public static int[] sortedSquares(int[] arr) {

        // find pivot element
        int p = findPivot(arr);
        int n = arr.length;
        int[] ans = new int[n];



        // merge array from 0 to p-1 and p to n-1
        int i= p-1;
        int j= p ;
        int c = 0;

        for( ;i>=0 && j<n;)
        {
            if(arr[i]* arr[i]< arr[j]*arr[j])
            {
                ans[c] = arr[i]* arr[i];
                c++;
                i--;
            }

            else
            {
                ans[c] = arr[j]* arr[j];
                c++;
               j++;
            }
        }
        while(i>=0)
        {
            ans[c] = arr[i]* arr[i];
            c++;
            i--;

        }
        while (j<n)
        {
            ans[c] = arr[j]* arr[j];
            c++;
            j++;
        }
        for(int k=0; k< n; k++)
        {
            System.out.print(ans[k]+" ");
        }
        return ans;

    }

    static int findPivot(int[] arr)
    {
        int pivot = 0;
        for (int i=0; i< arr.length; i++)
        {
            if(arr[i] >= 0)
            {
                pivot = i;
                break;
            }

        }
        return pivot;
    }
}
