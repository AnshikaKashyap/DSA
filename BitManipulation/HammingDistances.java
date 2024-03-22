package BitManipulation;
/*Hamming Distance is computed between two integers a and b. It is the total number of corresponding bits that are different in the binary representation of a and b.

For a = 4, b=17
Hamming Distance (4, 17) = 3

Q. We have been given an integer array Arr[N] containing non-negative numbers. Find the sum of hamming distances between all pairs.

Input: Arr[3] = {4, 5, 2}

Output: 6     HD(4, 5) + HD(4, 2) + HD(5, 2) = 6*/
public class HammingDistances {
    public static void main (String[] args)
    {
        int[] arr = {4,5,2};
        findHammingDis(arr);
    }
    static long findHammingDis(int[] arr)
    {
        long mask = (1l<<31);
        int n = arr.length; int ans = 0;

        for (int i = 31; i>=0; i--)
        {
            int cnt = 0;
            for (int j=0; j<n; j++)
            {
                if((mask & arr[j]) !=0)
                {
                    cnt++;
                }
            }
            ans = ans+ cnt * (n-cnt);
            mask = mask >> 1;
        }
        System.out.println(+ans);
        return ans;
    }
}
