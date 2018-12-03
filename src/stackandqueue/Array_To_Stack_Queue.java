package stackandqueue;

/**
 * @Classname Array_To_Stack_Queue
 * @Created by zgw
 * @Date 2018-11-29 16:57
 * @Description 用数组结构实现大小固定的队列和栈
 */
public class Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        /**
         * 获取栈顶元素
         * @return
         */
        public Integer peek() {
            //判断栈空
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        /**
         * 入栈
         * @param obj
         */
        public void push(int obj) {
            //判断栈满
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = obj;
        }

        /**
         * 出栈
         * @return
         */
        public Integer pop() {
            //判断栈空
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        //队列大小
        private Integer size;
        //出队位置
        private Integer first;
        //进队位置
        private Integer last;

        //循环队列
        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            //队列中数目
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            //循环队列
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }
    }
}
