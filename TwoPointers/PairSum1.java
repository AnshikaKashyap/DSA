package TwoPointers;
/*We have been given a sorted integer array Arr[N] and an integer ‘SUM’. If there exists a pair (i, j) such that Arr[i]+Arr[j]=SUM then return true otherwise false.
Input: Arr[5] = {2, -1, 0,  3, 9}, SUM = 8
Output: True */
public class PairSum1 {
    public static void main (String[] args)
    {
        int[] arr = {-1,0,2,3,9};
        int sum = 8;
        System.out.println(isPairSum(arr,sum));
    }

    static boolean isPairSum(int[] arr, int sum)
    {
        int i=0; int j = arr.length -1;
        while(i<j)
        {
            int cnt = arr[i]+arr[j];
            if (cnt == sum)
                return true;
            else if(cnt < sum)
                i++;
            else if(cnt > sum)
                j--;
        }
        return false;
    }
}
