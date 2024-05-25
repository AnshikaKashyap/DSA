package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue5 {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        q.add(1);
        System.out.println("queue: "+q.toString());
        reverseQueue(q);
        System.out.println("reverse queue: "+q.toString());
    }
    static void reverseQueue(Queue q)
    {
        if(q.isEmpty())
            return;
        int y = (int) q.peek();
        q.remove();
        reverseQueue(q);
        q.add(y);

    }
}
