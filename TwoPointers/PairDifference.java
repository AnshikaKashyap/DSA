package TwoPointers;
/*We have been given a sorted integer array Arr[N] and an integer ‘diff’. If there exists a pair (i, j) such that i≠j and Arr[i]-Arr[j]=diff then return true otherwise return false.

Input: Arr[5] = {11, 2, 7, 4, 15}, diff=2
Output: true            {(4, 2)}*/
public class PairDifference {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 11, 15};
        int diff = 2;
        System.out.println(countPairDiff(arr, diff));
    }

    static int countPairDiff(int[] arr, int diff) {
        int i = 0;
        int j = 1;
        int ans = 0;
        while (j < arr.length) {
            int cnt = arr[j] - arr[i];
            if (cnt < diff)
                j++;
            else if (cnt > diff) {
                i++;
                if (i == j) {
                    j++;
                }
            } else {

                if (arr[i] == arr[j]) {
                    int n = (j - i + 1);
                    ans = ans + (n * (n - 1) / 2);
                    break;
                } else {
                    int c1 = 0;
                    int c2 = 0;
                    int v1 = arr[i];
                    int v2 = arr[j];
                    while (arr[i] == v1) {
                        i++;
                        c1++;
                    }

                    while (arr[j] == v2) {
                        j++;
                        c2++;
                    }
                    ans = ans + (c1 * c2);
                }

            }

        }
        return ans;

    }
}
