package TwoPointers;
/*We have been given a sorted integer array Arr[N] and we have to find the count of the total number of pairs (i, j) such that Arr[i]+Arr[j]=SUM where i≠j.
*/
public class PairSum2 {
    public static void main (String[] args)
    {
        int[] arr = {1,4,4,5,5,5,6,6,11};
        int sum = 10;
        System.out.println(countPairSum(arr,sum));
    }

    static int countPairSum(int[] arr, int sum)
    {
        int i=0; int j = arr.length -1;
        int ans = 0;
        while(i<j)
        {
            int cnt = arr[i]+arr[j];
            if(cnt < sum)
                i++;
            else if(cnt > sum)
                j--;
            else if(cnt == sum)
            {
                if(arr[i] == arr[j])
                {
                    int n = (j-i+1);
                    ans = ans+(n*(n-1)/2);
                    break;
                }
                else{
                    int c1=0; int c2=0;
                    int v1 = arr[i]; int v2 = arr[j];
                    while(arr[i] == v1)
                    {
                        i++;
                        c1++;
                    }

                    while(arr[j] == v2)
                    {
                        j--;
                        c2++;
                    }
                    ans = ans+(c1*c2);
                }
            }
        }
        return ans;
    }
}
