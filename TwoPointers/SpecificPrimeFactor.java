package TwoPointers;
/*We have been given three prime numbers n1, n2, n3 and an integer N. Find the Nth natural number whose prime factorisation contains no other prime factor than n1, n2 or n3 i.e. num = (n1^i)*(n2^j)*(n3^k).

Input: n1 = 2, n2 = 3, n3 = 5, N = 7

Output: 8      (2^3.3^0.5^0)*/
public class SpecificPrimeFactor {
    public static void main (String[] args)
    {
        int n1 = 2; int n2 =3; int n3 = 5; int N = 7;
        int[] arr = new int[N];
        arr[0] = 1;
        int p1 = 0; int p2 = 0; int p3 = 0;
        for(int i = 1; i< N; i++)
        {
            int val = Math.min(arr[p1]*n1,Math.min(arr[p2]*n2,arr[p3]*n3));
            arr[i] = val;
            if(val == arr[p1]*n1) p1++;
            if(val == arr[p2]*n2) p2++;
            if(val == arr[p3]*n3) p3++;

        }
        for(int i =0; i< arr.length; i++)
        {
            System.out.println(arr[i]+"");
        }


    }
}
