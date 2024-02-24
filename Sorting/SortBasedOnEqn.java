package Sorting;/*Given a sorted integer array arr of size N, and three integers A, B and C. The task is to find a new array where ith
element of the new array = A * arr[i] * arr[i] + B * arr[i] + C where A ≠ 0. You have to print the new array in sorted (ascending) order.*/

public class SortBasedOnEqn {
    public static void main (String [] args){
        int[] nums = {-1,0,1,2,3,4};
        int[] eqn = {-1,2,-1};
        // output =-9 -4 -4 -1 -1 0
        sortedSquares(nums,eqn);
    }

    public static int[] sortedSquares(int[] arr, int[] eqn) {

        // find pivot element
        int p = findPivot(arr,eqn);
        int n = arr.length;
        int[] ans = new int[n];



        // merge array from 0 to p-1 and p to n-1
        int i= 0;
        int j= n-1 ;
        int c = 0;

        for( ;i<p && j>=p;)
        {
            if((eqn[0]*arr[i]* arr[i]+eqn[1]*arr[i]+eqn[2])< (eqn[0]*arr[j]* arr[j]+eqn[1]*arr[j]+eqn[2]))
            {
                ans[c] = eqn[0]*arr[i]* arr[i]+eqn[1]*arr[i]+eqn[2];
                c++;
                i++;
            }

            else
            {
                ans[c] = eqn[0]*arr[j]* arr[j]+eqn[1]*arr[j]+eqn[2];
                c++;
                j--;
            }
        }
        while(i<p)
        {
            ans[c] = eqn[0]*arr[i]* arr[i]+eqn[1]*arr[i]+eqn[2];
            c++;
            i++;

        }
        while (j>=p)
        {
            ans[c] = eqn[0]*arr[j]* arr[j]+eqn[1]*arr[j]+eqn[2];
            c++;
            j--;
        }
        for(int k=0; k< n; k++)
        {
            System.out.print(ans[k]+" ");
        }
        return ans;

    }

    static int findPivot(int[] arr, int[] eqn)
    {
        // -B/2A]
        int pivot_point = (-eqn[1]/2*eqn[0]);
        System.out.println(+pivot_point);
        int pivot = 0;
        for (int i=0; i< arr.length; i++)
        {
            if(arr[i] >= pivot_point)
            {
                pivot = i;
                break;
            }

        }
        return pivot;
    }
}
