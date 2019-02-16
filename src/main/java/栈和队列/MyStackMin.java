package 栈和队列;

import java.util.Stack;

/**
 *实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class MyStackMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStackMin() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your Stack is Empty.");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your Stack is Empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStackMin st = new MyStackMin();
        st.push(2);
        st.push(1);
        st.push(5);
        st.push(6);
        System.out.println(st.getMin());
    }
}
