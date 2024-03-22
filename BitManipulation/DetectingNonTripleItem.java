package BitManipulation;
/* We have been given an integer array Arr[N] where every 32 bit number comes thrice and one element appears once. Find that element.*/
public class DetectingNonTripleItem {
    public static void main (String[] args)
    {
        int[] arr = {11, 3, 10, 11, 11, 3, 3, 10, 10, 55};
        findSingleNum(arr);
    }
    static long findSingleNum(int[] arr)
    {
        long mask = (1l << 31);
        long ans = 0;
        // count no of 1s at each of 32 bit
        for(int i=31; i>=0; i--)
        {
            int count =0;
            for(int j=0; j<arr.length; j++)
            {
                if((arr[j] & mask) !=0)
                {
                    count++;
                }

            }
            if(count % 3 != 0)
            {
                ans = ans+mask;

            }
            mask = mask >> 1;
        }
        System.out.println(+ans);
        return ans;
    }

}
