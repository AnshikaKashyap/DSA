import java.util.Arrays;
import java.util.Scanner;

/*Farmer John has built a new long barn, with N stalls. The stalls are located along a straight line at positions x1,...,xN
His C cows dont like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from
hurting each other, Farmer John wants to assign the cows to the stalls, such that the minimum distance between any two of them
is as large as possible. What is the largest minimum distance?
Input Format

The first line of input contains an integer N
, number of stalls.
The second line of input contains N
space-separated integers x[1],x[2],...,x[N]
.
The third line of input contains an integer T
, number of testcases.
The first line of each testcase contains an integer C
, number of cows.
Sample Input 0

5
1 2 8 4 9
1
3

Sample Output 0

3

*/
public class PlaceTheCows {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i< num; i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int test_case = sc.nextInt();
        for(int i=0; i<test_case; i++)
        {
            int c = sc.nextInt();
            if(c > num)
            {
                System.out.println(0);
            }
            else {
                getMaxDistance(c, num, arr);
            }
        }

    }

    static boolean isPossible(int mid,int c, int num, int[] arr)
    {
        int count = 1;int prev = arr[0];
        for(int i=1; i< num; i++)
        {
            if((arr[i] - prev) < mid)
            {
                continue;
            }
            else {
                count++;
                prev = arr[i];
            }
        }

        return count >= c;
    }

    static void getMaxDistance(int c, int num, int[] arr)
    {
        int l=0;
        int h = arr[num -1] - arr[0];
        while(l<=h)
        {
            int mid = (l+h)/2;
            if(!isPossible(mid,c,num,arr)){
                h = mid -1;
            }
            else if(isPossible(mid,c,num,arr))
            {
                if(!isPossible(mid+1,c,num,arr))
                {
                    System.out.println(mid);
                    return;
                }
                else l = mid + 1;
            }
        }
    }
}
