package BitManipulation;
/*find if ith bit of a num is even or odd*/
public class IthBit {
    public static void main (String [] args)
    {
        int num = 10;
        findIthBit(10,7);

    }
    static void findIthBit(int num, int i)
    {
        int mask = num << i;
        if((num & mask) == 0)
        {
            System.out.println(i+"th bit is 0.");
        }
        else System.out.println(i+"th bit is 1.");
    }
}
