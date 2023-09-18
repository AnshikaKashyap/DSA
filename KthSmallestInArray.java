import java.util.Scanner;
/*Given an array arr[] of size N having no duplicates and an integer K, the task is to find the Kth smallest element from the array in constant extra space and the array can’t be modified.

Input Format

    The first line contains N

, total number of elements
The second line contains N
space-separated integers arr[1],arr[2],arr[3],.....,arr[N]
The third line contains K

Constraints

    1

≤ N ≤ 105
1
≤ arr[i] ≤ 106
1
≤ K ≤ N

Output Format

    Print the k-smallest element

Sample Input 1

6
7 10 4 3 20 15
4

Sample Output 1

10*/
public class KthSmallestInArray {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< n; i++)
        {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        findKthElement(arr,k);
    }

    static void findKthElement(int[] arr, int k)
    {
        int max = findMax(arr);
        int min = findMin(arr);
        int l = min; int h = max;
        while(l<=h)
        {
            int mid = (l+h)/2;

            if (getCount(mid,arr) >= k)
            {
                if(getCount(mid-1,arr)<k)
                {
                    System.out.println(mid);
                    return;
                }
                else {
                    h = mid-1;
                }
            }

            else if (getCount(mid,arr)< k)
            {
                l = mid+1;
            }

        }

    }

    static int findMax(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i=0; i< arr.length; i++)
        {
            if(arr[i] > max )
            {
                max = arr[i];
            }

        }

        return max;
    }

    static int findMin(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        for (int i=0; i< arr.length; i++)
        {
            if(arr[i] < min )
            {
                min = arr[i];
            }

        }
        return min;
    }

    static int getCount(int i, int[] arr)
    {
        int count = 0;
        for(int j=0; j< arr.length; j++)
        {
            if(arr[j] <= i)
            {
                count++;
            }
        }
        return count;
    }
}
