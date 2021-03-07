package 剑指offer;

import java.util.Stack;

public class DoubleSQueue6 {
    /*
    题7：用两个栈实现一个队列，完成队列的push和pop操作，队列中的元素为int类型。
     */

    /**
     * 时间复杂度0(1），空间复杂度0(1）
     */

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空");
        }

        //stack2.isEmpty()保证后面stack1再加入数据后，stack2先把之前的取完后再添加
        //保证队列的FIFO
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
