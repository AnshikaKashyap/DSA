package BitManipulation;

public class OddEven {
    public static void main (String []args)
    {
        isOddEven(8);
    }
    static void isOddEven(int num)
    {
        if((num & 1) == 1)
            System.out.println(num+ " is odd");
        else System.out.println(num+ " is even");
    }
}
