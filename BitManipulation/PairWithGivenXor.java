package BitManipulation;

import java.util.Arrays;

/*We have been given an integer array Arr[N] and an integer k. We have to check if there is a pair (Arr[i], Arr[j]) such that Arr[i]^Arr[j]=k.
 Arr[i]^Arr[j] = k
 Arr[i]^Arr[i]^Arr[j] = Arr[i] ^ K ==> Arr[j] = Arr[i] ^K

 Arr[j] = Arr[i]^k

Input: Arr[5] = {7, 10, 3, 5, 9}, k=15

Output: True*/
public class PairWithGivenXor {
    public static void main(String[] args) {
        {
            int[] arr = {7, 10, 3, 5, 9}; // 3,5,7,9,10

            int k = 15;
            System.out.println(ifGivenPairAvailable(arr,k));
        }
    }
    static boolean ifGivenPairAvailable(int[] arr,int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int num = arr.length;
            int l = i;
            int h = num - 1;
            int mid;
            while (l <= h) {
                 mid = (l+h) / 2;
                if (arr[mid] == (arr[i] ^ k)) {
                    return true;
                }
                else if (arr[mid] > (arr[i]^k))
                    h = mid-1;
                else l = mid+1;
            }
        }
        return false;
    }
}
