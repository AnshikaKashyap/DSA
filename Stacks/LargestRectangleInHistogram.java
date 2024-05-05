package Stacks;

import java.util.Stack;

/*Given an array of integers heights representing the histogram's bar height where the width of
 each bar is 1, return the area of the largest rectangle in the histogram.
 Input: heights = [2,1,5,6,2,3]
Output: 10*/
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int[] nse = findNextSmallerElement(heights);
        for(int i=0; i< nse.length; i++)
        {
            System.out.print(nse[i]+" ");
        }
        System.out.println();
        int[] pse = findPrevSmallerElement(heights);
        for(int i=0; i< pse.length; i++)
        {
            System.out.print(pse[i]+" ");
        }
        System.out.println();
        int ans = Integer.MIN_VALUE;
        for(int i=0; i< heights.length; i++)
        {
            int max_width;
            int max_area;
            max_width = (nse[i]-pse[i]-1);
            max_area = (max_width*heights[i]);
            ans = Math.max(ans,max_area);
        }
        System.out.println("ans is: "+ans);
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

    static int[] findPrevSmallerElement(int[] arr)
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

                while ( !(stack.isEmpty())&&arr[i] < arr[(int)stack.peek()]) {

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
