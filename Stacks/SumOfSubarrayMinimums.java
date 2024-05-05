package Stacks;

import java.util.Stack;
/*Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
Since the answer may be large, return the answer modulo 109 + 7.
Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444*/
public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int[] nse = findNextSmallerElement(arr);
        int[] pse = findPrevSmallerEqualElement(arr);
        int ans = 0;
        for(int i=0; i< arr.length; i++)
        {
//            ans = ans+((nse[i]-i)*(i-pse[i])*arr[i]);
            ans += (((((nse[i]-i)%(Math.pow(10,9)+7))*((i-pse[i])%(Math.pow(10,9)+7)))%(Math.pow(10,9)+7))%(Math.pow(10,9)+7)*arr[i]%(Math.pow(10,9)+7))%(Math.pow(10,9)+7);
        }
        System.out.println(+ans);
    }
    static int[] findNextSmallerElement(int[] arr)
    {
        int[] ans = new int[arr.length];
        Stack stack = new Stack();
        // initialize stack
        for(int i=0; i< arr.length; i++)
        {
            if(stack.isEmpty())
            {
                stack.push(i);
            }
            else {

                while ( !(stack.isEmpty())&&arr[i] < arr[(int)stack.peek()]) {

                    ans[(int)stack.peek()] = i;
                    stack.pop();
                }

                stack.push(i);

            }
        }

        while(!(stack.isEmpty()))
        {
            ans[(int)stack.peek()] = arr.length;
            stack.pop();
        }

        return ans;
    }

    static int[] findPrevSmallerEqualElement(int[] arr)
    {
        int[] ans = new int[arr.length];
        Stack stack = new Stack();
        // initialize stack
        for(int i=arr.length-1; i>=0; i--)
        {
            if(stack.isEmpty())
            {
                stack.push(i);
            }
            else {

                while ( !(stack.isEmpty())&&arr[i] <= arr[(int)stack.peek()]) {

                    ans[(int)stack.peek()] = i;
                    stack.pop();
                }

                stack.push(i);

            }
        }

        while(!(stack.isEmpty()))
        {
            ans[(int)stack.peek()] = -1;
            stack.pop();
        }

        return ans;
    }

}
