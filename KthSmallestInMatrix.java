import java.util.Scanner;
/*Given an N ∗ N matrix where each of the rows and columns are sorted in ascending order, print the K−th

smallest element in the matrix.

Note that it is the K−th
smallest element in the sorted order, not the k−th

distinct element.

Try to solve this question using Binary Search

Input Format

    The first line of input contains N

The second line contains N
∗ N
integers in the form of a matrix
The third line contains an integer K

Constraints

    1

≤ N ≤ 300
−109
≤ matrix[i][j] ≤ 109
1
≤ K ≤ N2

Output Format

    Print the K−th

    smallest element in the matrix.

Sample Input 0

3
1 5 9
10 11 13
12 13 15
8

Sample Output 0

13

Explanation

    Matrix elements in a sorted order are 1,5,9,10,11,12,13,13,15

. Thus, 13 is the 8−th smallest element in the matrix*/
public class KthSmallestInMatrix {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][]arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0; j< n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        findKthSmallElement(arr, n, k);
    }

    static void findKthSmallElement(int[][]arr, int n, int k)
    {
        int h = getMax(arr,n);
        int l = getMin(arr,n);
        int count;
        while(l<=h)
        {
            int mid = (l+h)/2;
            count = getCount(arr,n,mid);

            if(getCount(arr,n,mid) >= k)
            {
                if (getCount(arr,n,mid-1) < k)
                {
                    System.out.println(mid);
                    return;
                }
                else h = mid-1;
            }

            else if(getCount(arr,n,mid) < k)
            {
                l = mid+1;
            }


        }



    }

    static int getMax(int[][]arr, int n)
    {
        int max= Integer.MIN_VALUE;
        for(int i=0; i< n; i++)
        {
            if(arr[i][n-1] > max)
                max = arr[i][n-1];
        }
        return max;
    }

    static int getMin(int[][]arr, int n)
    {
        int min= Integer.MAX_VALUE;
        for(int i=0; i< n; i++)
        {
            if(arr[0][i] < min)
                min = arr[0][i];
        }
        return min;
    }

    static int getCount(int[][] arr, int n, int k) {
        int count = 0;

        for (int i = 0; i < n; i++) {

            int l = 0;
            int h = n - 1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (arr[i][mid] > k) {
                    if (mid != 0 && arr[i][mid - 1] <= k) {
                        count = count + mid;
//                        System.out.println("getCount 15 inner loop"  + " " + count);
                        break;

                    } else h = mid - 1;

                }
                else if (arr[i][mid] <= k && mid == n-1) {
                    count = count + mid+1;
//                    System.out.println("getCount 15 inner loop"  + " " + count);
                    break;
                }
                else if (arr[i][mid] <= k) {
                    l = mid + 1;
                }


            }


        }
        return count;
    }
}
