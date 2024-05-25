package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackByQueues4 {
    Queue<Integer> q;
    int top;
    public void push(int x)
    {
        q.add(x);
        top =x;
    }

    public int pop()
    {
        Queue<Integer> temp = new LinkedList<>();
        while(q.size() > 1)
        {
            if(q.size() == 2){
                top= q.peek();
            }
            temp.add(q.peek());
            q.remove();
        }
        int ans = q.peek();
        q.remove();
        q = temp;
        return ans;
    }

    public int peek()
    {
        return top;
    }
}
