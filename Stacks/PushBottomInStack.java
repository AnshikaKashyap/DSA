package Stacks;

import java.util.Stack;

/*We have been given a stack ‘stk’ and an element ‘x’. We have to insert ‘x’ at the bottom of the stack ‘stk’ using only the standard operators of a stack.  */
public class PushBottomInStack {
    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(3);
        stk.push(2);
        pushBottom_recursion(stk,1);   //2 3 1
        while(!stk.isEmpty())
        {
            System.out.println(stk.peek());
            stk.pop();
        }

    }
    static void pushBottom(Stack stack, int x)
    {
        Stack temp = new Stack();

        while(!stack.isEmpty())
        {
            temp.push(stack.pop());
        }
        stack.push(x);
        while(!temp.isEmpty())
        {
            stack.push(temp.pop());
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

}
