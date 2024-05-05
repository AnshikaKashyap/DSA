package Stacks;

import java.util.Stack;

public class DesignMinStack {
    Stack stk;
    int curr_min ;
    public DesignMinStack() {
        curr_min = Integer.MAX_VALUE;
        this.stk = new Stack<>();
    }

    public void push(int val) {
        if(stk.isEmpty())
        {
            stk.push(val);
            curr_min = val;
            return;
        }
        if(val<curr_min) {
            //push 2*x-min so that it is always less than min
            stk.push(2*val-curr_min);
            curr_min = val;
                 }
        else {
            stk.push(val);
        }


    }

    public void pop() {
        if ((int)stk.peek() < curr_min)
        {
            curr_min = (2*curr_min-(int)stk.peek());
            stk.pop();
        }
        else stk.pop();

    }

    public int top() {
        if((int)stk.peek() < curr_min)
            return curr_min;
        else return (int)stk.peek();


    }

    public int getMin() {
        return curr_min;

    }
    public static void main(String[] args) {
        DesignMinStack minStack = new DesignMinStack();
        minStack.push(12);
        minStack.push(-12);
        minStack.push(11);
        minStack.push(10);
        minStack.push(9);
        System.out.println(minStack.getMin());

    }
}


