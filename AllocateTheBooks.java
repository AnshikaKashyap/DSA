import java.util.Scanner;

/*You are given N number of books. Every i−th book has Ai

number of pages.

You have to allocate contiguous books to M
number of students. There can be many ways or permutations to do so. In each permutation, one of the M

students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

Note: Answer always exists and allotment should be in contiguous order (see the explanation for better understanding).

Input Format

    The first line of input contains an integer n

, size of the array
The second line of input contains n
space-separated integers a[1],a[2],...,a[n]
.
The third line of input contains m
, number of students.
Sample Input 0
4
12 34 67 90
2
Sample Output 0
113
Explanation

Allocation can be done in following ways
(12) and (34,67,90) Maximum Pages = 191
(12,34) and (67,90) Maximum Pages = 157
(12,34,67) and (90) Maximum Pages =113
Therefore, the minimum of these cases is 113
, which is selected as the output.*/
public class AllocateTheBooks {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i< num; i++)
        {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        findMinAllotedPage(arr,m);

    }

    static int getMin(int[] arr)
    {
        // min should be max of all elements in array
        int min = arr[0];
        for(int i=1; i< arr.length; i++)
        {
            if(arr[i] > min)
            {
                min = arr[i];
            }
        }
        return min;
    }

    static int getMax(int[] arr)
    {
        int max = arr[0];
        for(int i=1; i< arr.length; i++)
        {

            max = max + arr[i];

        }
        return max;
    }

    static boolean isPossible(int[] arr, int num, int m, int n)
    {
        int count =1;
        int sum = arr[0];

        for(int i=1; i< num; i++)
        {
            //if any pagecount of a book is > n, then return false
            if (arr[i] > n)
                return false;

            else if(sum+arr[i] <= n)
            {
                sum = sum+arr[i];

            }
            else
            {
                count ++;
                sum = arr[i];
            }
        }

        return count <= m;

    }

    static void findMinAllotedPage(int[] arr,int m)
    {
        int l = getMin(arr);
        int h = getMax(arr);
        // while(l<=h)
        // {
        //     int mid = (l+h)/2;
        //     if(!isPossible(arr,arr.length,m,mid))
        //     {
        //         l = mid+1;
        //     }
        //     else if(isPossible(arr,arr.length,m,mid))
        //     {
        //         if(!isPossible(arr,arr.length,m,mid-1))
        //         {
        //             System.out.println(mid);
        //             return;
        //         }
        //         else h = mid-1;
        //     }
        // }
        while(l<h)
        {
            int mid = l+(h-l)/2;
            if(!isPossible(arr,arr.length,m,mid))
            {
                l = mid+1;
            }
            else h = mid;

        }

        System.out.println(l);
    }

}
