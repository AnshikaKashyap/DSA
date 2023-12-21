import java.util.Scanner;

public class SmallestGoodBase {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i=0; i< test_case; i++)
        {
            long num = sc.nextInt();
            getSmallestGoodBase(num);
        }
    }

    static void getSmallestGoodBase(long num)
    {
        for (long i=63; i>1; i--)
        {
            long l= 2; long h = (num-1);
            while(l<= h)
            {
                long mid = (l+h)/2;
                // check if mid is a good base or not with i terms
                long temp_val=0; long x=1; long flag=0;
                for(long j=0; j<i; j++)
                {
                    temp_val = temp_val+x;
                    if(temp_val >= num) break;
                     if (j < i-1 &&((num - temp_val)/x) < mid)
                    {
                        flag = 1;
                        break;
                    }
                    if (j < i)
                        x = x*mid;
                }

               if(temp_val > num || flag == 1)
                {
                    h = mid -1;
                }
                else if(temp_val < num)
                    l= mid+1;
                else if (temp_val == num)
//                else
                {
                    System.out.println(mid);
                    return;
                }
            }
        }
    }
}

