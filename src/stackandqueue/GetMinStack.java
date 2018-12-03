package stackandqueue;

import java.util.Stack;

/**
 * @Classname GetMinStack
 * @Created by zgw
 * @Date 2018-12-01 15:52
 * @Description 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】
 *  1．pop、push、getMin操作的时间复杂度都是O(1)。
 *  2．设计的栈类型可以使用现成的栈结构。
 *
 *  实现方式：除了存储数据的栈外，在定义一个存储最小值的栈。
 *  进行入栈操作时，数据栈正常入栈，最小值栈将数据与最小值栈顶元素进行比较 压入最小的值
 */
public class GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**
         * 入栈
         * @param newNum
         */
        public void push(int newNum) {
            //最小值栈空直接压入
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                //新进数字小于等于最小值栈顶，新数字进栈
                this.stackMin.push(newNum);
            }
            //新进数字比最小值栈顶值大，不操作最小值栈
            //操作数据栈
            this.stackData.push(newNum);
        }

        /**
         * 出栈
         * @return
         */
        public int pop() {
            //数据栈为空
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            //数据栈出栈
            int value = this.stackData.pop();
            //如果数据栈和最小值栈栈顶数据相同，最小值栈也出栈
            //这样做保证了当前数据栈中的最小值，在最小值栈中栈顶。
            //同时，最小值栈顶的元素必然属于当前数据栈，且是数据栈中的最小值
            //真正做到，当前栈中的最小值，而不是没有意义的一个数字
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        /**
         * 获取栈中的最小值
         * @return
         */
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**
         * 入栈
         * @param newNum
         */
        public void push(int newNum) {
            //判断栈空
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getmin()) {
                //元素比最小值栈中值还小，操作最小值栈，压入新的元素
                this.stackMin.push(newNum);
            } else {
                //元素不比最小值栈栈顶元素小，同样操作栈，只是压入栈的是当前的最小值栈顶元素
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            //操作数据栈
            this.stackData.push(newNum);
        }

        /**
         * 出栈
         * @return
         */
        public int pop() {
            //判断栈空
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            //由于数据栈和最小值栈中元素相同，数据栈压入一个，最小值栈也必压入一个
            //因此出栈时，也同时进行出栈，且留在数据栈中的最小值，是最小值栈的栈顶
            this.stackMin.pop();
            return this.stackData.pop();
        }

        /**
         * 获取最小值
         * @return
         */
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
    }
}
