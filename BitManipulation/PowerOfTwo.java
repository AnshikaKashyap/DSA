package BitManipulation;

public class PowerOfTwo {
    public static void main (String [] args)
    {
        int num = 16;
        isPowerOfTwo(num);
    }
    static void isPowerOfTwo(int num)
    {
        if((num & (num-1)) == 0)
            System.out.println(num+" is power of two");
        else System.out.println(num+" is not a power of two");
    }
}
