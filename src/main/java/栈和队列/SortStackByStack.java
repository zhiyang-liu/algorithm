package 栈和队列;

import java.util.Stack;

public class SortStackByStack {
    /**
     * 将栈从栈顶到栈底从小到大排列，只需申请一个栈，除此之外，可以申请新的变量，但不能申请额外的数据结构。
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(3);
        SortStackByStack.sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
