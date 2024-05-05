package Stacks;

public class Stacks {
    int[] arr = new int[10];
    int top;

    public Stacks() {
//        this.arr = arr;
        this.top = -1;
    }
    Stacks s = new Stacks();

    // push,pop, top, isEmpty, isFull
    public void push(int x)
    {
        if(isFull())
            System.out.println("stack is already full !!");
        else {
            s.top ++;
            s.arr[s.top] = x;
        }

    }
    public void pop()
    {
        if(isEmpty())
            System.out.println("stack is already empty !!");
        else {
            s.top --;
        }

    }
    public int top()
    {
        if(isEmpty()) {
            System.out.println("Underflow !!");
        }
        else {
            return s.arr[s.top];
        }

        return 0;
    }
    public boolean isEmpty()
    {
        if(s.top == -1)
        {
            return true;
        }
        else return false;
    }

    public boolean isFull()
    {
        if(s.top == 9)
        {
            return true;
        }
        else return false;
    }
}
