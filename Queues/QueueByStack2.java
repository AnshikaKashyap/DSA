package Queues;

import java.util.Stack;

public class QueueByStack2 {
    Stack<Integer> stk1,stk2;
    int front;

    public QueueByStack2() {

    }

    public void push(int x)
    {
        if(stk1.empty())
            front = x;
        stk1.push(x);
    }

    public int pop()
    {
        int ans;
        while(!(stk1.isEmpty()))
        {
            stk2.push(stk1.peek());
            stk1.pop();
        }
        ans = stk2.peek();
        stk2.pop();
        while(!(stk2.isEmpty()))
        {
            if(stk1.isEmpty())
            {
                front = stk2.peek();
            }
            stk1.push(stk2.peek());
            stk2.pop();
        }
        return ans;
    }
}
