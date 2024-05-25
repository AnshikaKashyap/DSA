package Queues;

import java.util.Stack;

public class QueueByStack3 {
    // we'll use stk1 for push and stk2 for pop
    Stack<Integer> stk1,stk2;
    int front;
    int bottomStk1;

    public void push(int x)
    {
        if(stk1.isEmpty() && stk2.isEmpty())
            front = x;
        else if (stk1.isEmpty()) {
            bottomStk1 = x;
            
        }
        stk1.push(x);

    }

    public int pop()
    {
        int ans;
        if(stk2.isEmpty())
        {
            while(!(stk1.isEmpty()))
            {
                stk2.push(stk1.peek());
                stk1.pop();

            }
        }
        ans = stk2.peek();
        stk2.pop();
        if(!(stk2.isEmpty()))
            front = stk2.peek();
        else if (!(stk1.isEmpty()))
            front = bottomStk1;



        return ans;
    }

    public int peek()
    {
        return front;
    }
    public boolean isEmpty()
    {
        return (stk1.isEmpty() && stk2.isEmpty());
    }
}
