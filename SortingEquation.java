import java.util.*;

/*You are given a set S of integers.

Find the total number of sextuples (a,b,c,d,e,f):a,b,c,d,e,f∈S;d≠0

that satisfy:

(a*b+c) = d*(e+f)

*/
public class SortingEquation {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i=0;i< test_case; i++)
        {
            int num = sc.nextInt();
            long[] arr = new long[num];
            // populate the set
            for(int j=0; j<num; j++)
            {
                arr[j] = sc.nextLong();
            }

            findSextuples(arr,num);
        }

    }

    public static void findSextuples(long[] arr, int n)
    {
        List lhs_output = new ArrayList<Long>();
        List rhs_output = new ArrayList<Long>();

        for(int i=0; i< n; i++)
        {
            for(int j=0; j< n; j++)
            {
                for(int k=0; k<n; k++)
                {

                    long lhs_res = (arr[i]*arr[j])+arr[k];
                    lhs_output.add(lhs_res);
                }
            }
        }

        for(int i=0; i< n; i++)
        {
            for(int j=0; j< n; j++)
            {
                for(int k=0; k<n; k++)
                {
                    if(arr[i]!=0)
                    {
                        long rhs_res = arr[i]*(arr[j]+arr[k]);
                        rhs_output.add(rhs_res);
                    }
                }
            }
        }

        for(int i=0; i< rhs_output.size();i++)
        {
            System.out.print(rhs_output.get(i)+" ");
        }
        System.out.println();
        for(int i=0; i< lhs_output.size();i++)
        {
            System.out.print(lhs_output.get(i)+" ");
        }
        System.out.println();
        HashMap<Long,Long> freq_map = new HashMap<>();

        for(int i=0;i<rhs_output.size();i++)
        {
            long temp = (long)rhs_output.get(i);
            if(freq_map.containsKey(temp))
            {
                freq_map.put(temp,freq_map.get(temp)+1);
            }
            else freq_map.put(temp,1L);
        }

        long frequency = 0;
        for(int i=0;i<lhs_output.size();i++)
        {
            long temp = (long)lhs_output.get(i);
            if(freq_map.containsKey(temp))
            {
                frequency = frequency+freq_map.get(temp);
            }
        }

        System.out.println(frequency);
    }


}


