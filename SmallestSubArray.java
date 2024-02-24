/*We have been given an array Arr[N] containing only positive elements and an integer ‘k’. We have to return
 the length of the smallest subarray with sum >= k.

Input: Arr [7] = {5 1 4 3 2 9}; k=10
Output: 2 */

public class SmallestSubArray {
    public static void main (String [] args)
    {
        int[] arr = {5,1,4,3,2,9};
        int k = 10;
        getSmallestSubArr(arr,k);
    }

    static void getSmallestSubArr(int[] arr, int k)
    {
        // create prefix sum arr
        int[] prefix_sum = new int [arr.length];
        prefix_sum[0] = arr[0];
        for (int i=1; i< arr.length; i++)
        {
            prefix_sum[i] = prefix_sum[i-1]+arr[i];
        }
                int ans = Integer.MAX_VALUE;
        //
        for(int i=0; i< arr.length; i++)
        {
            int low = i;
            int high = arr.length -1;
            int mid;
            while(low <= high)
            {
                mid = (low+high)/2;
                if(prefix_sum[mid] < k)
                {
                    low = mid+1;
                }
                else if ((prefix_sum[mid] > k) && (prefix_sum[mid-1] < k))
                {
                    ans = Math.min(ans,mid);
                    break;
                }
                else if ((prefix_sum[mid] > k) && !(prefix_sum[mid-1] < k))
                {
                    high = mid-1;
                }
                else if(prefix_sum[mid] == k)
                {
                    ans = Math.min(ans,mid);
                    break;
                }

            }
        }
        System.out.println("answer is: "+ans);

    }
}
