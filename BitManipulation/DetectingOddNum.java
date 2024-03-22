package BitManipulation;

public interface DetectingOddNum {
    public static void main (String[] args)
    {
      int[] arr = {1,2,3,2,1};
        findOddOccurance(arr);
    }

    static int findOddOccurance(int[] arr)
    {
        //  Since we know that x^x = 0 and 0^x = x therefore we can take the XOR of all
        //  the array elements and the final answer will be the required element which is appearing once.
        int ans = 0;
        for(int i=0; i< arr.length; i++)
        {
            ans = (ans ^ arr[i]);
        }
        System.out.println("ans is: "+ans);
        return ans;
    }
}
