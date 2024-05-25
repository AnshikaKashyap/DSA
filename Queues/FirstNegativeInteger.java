package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
* Input :
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output :
-8 0 -6 -6*/
public class FirstNegativeInteger {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int N = 5;
        int K = 2;
        printFirstNegativeInteger(arr,N,K);
    }
    static void printFirstNegativeInteger(int[] arr, int N, int K)
    {
         Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<K; i++)
        {
            if(arr[i] < 0)
                queue.add(i);
        }
        for(int i=K; i< N; i++)
        {
            if(queue.isEmpty())
                System.out.println("0");
            else
                System.out.println(arr[queue.peek()]);
            if(!queue.isEmpty() && queue.peek() == (i-K))
                queue.remove();
            if(arr[i] < 0)
            {
                queue.add(i);
            }
        }
        if(queue.isEmpty())
            System.out.println("0");
        else
            System.out.println(arr[queue.peek()]);

    }
    static void insertFirstNegative(Queue<Integer> q, int index, int[] arr)
    {
        while(q.isEmpty() && arr[index] < 0)
        {
            q.add(index);
        }
    }
}
