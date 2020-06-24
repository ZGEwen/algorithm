package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname StackAndQueueConvert
 * @Created by zgw
 * @Date 2018-12-01 16:25
 * @Description
 * 如何仅用队列结构实现栈结构？两个队列实现栈
 * 如何仅用栈结构实现队列结构？两个栈实现队列：用户数据只进push栈，用户拿数据只从pop栈拿
 */
public class StackAndQueueConvert {

    /**
     * 使用两个队列实现栈：将除最后一个元素外所有元素出队列，并逐个入队到help中，此时data队列中的留下的元素出队就是所求的
     * 交换data和help指向的位置
     */
    public static class TwoQueuesStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        /**
         * 入
         * @param pushInt
         */
        public void push(int pushInt) {
            data.add(pushInt);
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        /**
         * 出
         * @return
         */
        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        /**
         * 交换data和help队列的引用
         */
        private void swap() {
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }

    }

    /**
     * 两个栈实现队列：用户数据只进push栈，用户拿数据只从pop栈拿
     *  从push栈转移到pop栈的任何过程中，实现需要满足的两个限制条件：
     *      从push栈到pop栈中，需要把push中的所有数据一次全部放入pop栈中
     *      如果pop栈中有数据，新来数据进入push栈中，这时不能将push栈中数据放到pop栈中
     */
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        /**
         * 从push栈转换到pop栈中，这个转换可以发生在任意时刻，只要满足下面的两个条件
         */
        public void trans(){
            //pop栈非空，不能转换
            if (!stackPop.isEmpty()){
                return;
            }
            //push栈非空，将push栈全部转换到pop栈中
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

}
