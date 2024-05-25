package Queues;

import java.util.LinkedList;
import java.util.Queue;

/*Given an integer N>0. Print the binary representation of all numbers from 1 to N.
Input: N = 5
Output: 1, 10, 11, 100, 101*/
public class BinaryForms7 {

    public static void main(String[] args) {
        int num = 5;
        printBinaryForms(num);
    }

    static void printBinaryForms(int num) {
        int cnt = 0;
        int start = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (cnt < num) {
            int x = q.peek();
            System.out.println(x);
            cnt++;

        q.remove();
        q.add(x * 10);
        q.add(x * 10 + 1);
    }

    }

}
