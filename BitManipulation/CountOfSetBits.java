package BitManipulation;
/*Given a 32 bit number. find no of set bit (1s)in it.*/
public class CountOfSetBits {
    public static void main (String [] args)
    {
        find1s(4);
        find1s_1(4);
    }
    static void find1s(int num)
    {
        int cnt = 0;
        long mask = (1l << 31);
        while(mask != 0)
        {
            if((num & mask) != 0) cnt++;
            mask = mask >> 1;
        }
        System.out.println("count is "+cnt);
    }

    static void find1s_1(int num)
    {
        int cnt = 0;
        while(num!= 0)
        {
            num = (num & (num -1));
            cnt++;
        }
        System.out.println("count is "+cnt);
    }
}
