package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(3);
        stk.push(2);
        reverseStack(stk);   //3 2    2 3 1
        while(!stk.isEmpty())
        {
            System.out.println(stk.peek());
            stk.pop();
        }

    }

    static void pushBottom_recursion(Stack stack, int x)
    {
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int y = (int) stack.peek();
        stack.pop(); // stack is modified because of pop
        pushBottom_recursion(stack,x);
        stack.push(y);


    }
    static void reverseStack(Stack stack)
    {
        if(stack.isEmpty())
            return;
        int y = (int) stack.peek();
        stack.pop();
        reverseStack(stack);
        pushBottom_recursion(stack,y);

    }
}
