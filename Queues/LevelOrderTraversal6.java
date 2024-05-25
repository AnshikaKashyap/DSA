package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*Given a natural number ‘N’. We have to print the first ‘N’ natural numbers whose digits ϵ {1, 2, 3} in a sorted form.

Input: N = 10

Output: 1, 2, 3, 11, 12, 13, 21, 22, 23, 31

*/
public class LevelOrderTraversal6 {
    public static void main(String[] args) {
        int N =10;
        printNNaturalNum(N);

    }
    static void printNNaturalNum(int N)
    {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.add(0);
        while(cnt<N)
        {
            int x = q.peek();
            if(x !=0)
            {
                System.out.println(x);
                cnt++;
            }
            q.remove();
            q.add(x*10+1);
            q.add(x*10+2);
            q.add(x*10+3);
        }
        
    }
}
