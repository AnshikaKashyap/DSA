package BitManipulation;
/*We have been given two integers l and r. Find the bitwise AND of all the numbers from left to right.

Input: l=8, r=11

Output: 8*/
public class CumulativeBitwiseAND {
    public static void main (String[] args)
    {
        int m = 8; int n = 11;
        rangeAnd(8,11);

    }

    static long rangeAnd(int m, int n)
    {
        long mask = (1l << 31);
       long ans = 0;
       while(mask != 0)
       {
           if((mask & m) == (mask & n)) {
               if ((mask & m) != 0) {
                   ans = ans + mask;

               }
               mask = mask >> 1;
           }
               else
               {

                   break;
               }

           }

        System.out.println("ans is : "+ans);
        return ans;
    }
}
