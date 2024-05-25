package Queues;

public class CircularQueueUsingArrays1 {
    int[] arr = new int[10];
    int front;
    int back;
    int cnt;

    public void push()
    {
        // check if overflow
        if(cnt == 10)
        {
            System.out.println("overflow condn");
        }
        else back = (back+1)%10;



    }

    public void pop()
    {
        if(cnt == 0)
        {
            System.out.println("underflow condn");
        }
        else front = (front+1)%10;

    }

    public int peek()
    {
        if(cnt == 0)
        {
            System.out.println("underflow condn");
            return -1;
        }
        else return arr[front];
    }

}
