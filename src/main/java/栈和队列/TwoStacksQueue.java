package 栈和队列;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，支持队列的基本操作（add，poll，peek）
 *
 * 满足条件：
 * 1.如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush的数据全部压入。
 * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据。
 */
public class TwoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    /**
     * 入队
     * @param pushInt
     */
    public void push(int pushInt){
        stackPush.push(pushInt);
    }

    /**
     * 出队
     * @return
     */
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 获取队首元素
     * @return
     */
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue ts = new TwoStacksQueue();
        ts.push(1);
        ts.push(2);
        ts.push(3);
        System.out.println(ts.poll());
        ts.push(4);
        ts.push(5);
        System.out.println(ts.poll());
    }
}
