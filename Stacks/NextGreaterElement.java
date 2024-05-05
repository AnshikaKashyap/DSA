package Stacks;

import java.util.Stack;

/*We have been given an integer array Arr[N]. We have to find the next greater element of every array element.

Note: Next greater element of an element is the first element which is strictly greater than it and is towards its right.

Input: Arr[4] = {4, 5, 2, 25}

Output: NGE[4] = {5, 25, 25, NULL}

*/
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] ans = findNextGreaterElement(arr);
        for(int i=0; i< ans.length; i++)
        {
            System.out.println(ans[i]);
        }

    }
    static int[] findNextGreaterElement(int[] arr)
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

                while ( !(stack.isEmpty())&&arr[i] > arr[(int)stack.peek()]) {

                    ans[(int)stack.peek()] = arr[i];
                    stack.pop();
                }

                    stack.push(i);

            }
        }

        while(!(stack.isEmpty()))
        {
            ans[(int)stack.peek()] = 0;
            stack.pop();
        }

        return ans;
    }
}
