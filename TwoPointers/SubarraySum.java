package TwoPointers;
/*We have been given an unsorted array Arr[N], containing ‘N’ non-negative elements and an integer ‘SUM’. If there exists a subarray with sum = SUM then return true otherwise return false.

Input: Arr[5] = {5, 3, 4, 6, 2}, SUM = 15
Output: true        {3, 4, 6, 2}*/
public class SubarraySum {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 6, 2};
        int sum = 15;
        System.out.println(getSubarraySum(arr, sum));
    }

    private static boolean getSubarraySum(int[] arr, int sum) {
        int i=0; int j=0;
        int current_sum = arr[0];
        while(j<arr.length)
        {

            if(current_sum < sum)
            {

                    j++;
                if(j<arr.length) {
                    current_sum = current_sum + arr[j];
                }
            }
            else if (current_sum > sum)
            {
                current_sum = current_sum - arr[i];
                i++;
                if(i>j)
                {
                    j++;
                    if(j<arr.length) {
                        current_sum = arr[j];
                    }
                }
            }
            else if (current_sum == sum)
            {
                return true;
            }
        }
        return false;
    }

}
