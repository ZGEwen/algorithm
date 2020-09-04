//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 112 👎 0

import java.util.LinkedList;

// 用两个栈实现队列
public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        // 保证deleteHead是从第二个栈中出栈，appendTail从第一个栈中入栈
        // 从ll1-->ll2时，ll2必须为空，且ll1需要完全倒入ll2
        LinkedList<Integer> ll1,ll2;
        public CQueue() {
            ll1=new LinkedList<>();
            ll2=new LinkedList<>();
        }

        /**
         * 添加到ll1中，无限制
         * @param value
         */
        public void appendTail(int value) {
            ll1.addLast(value);
        }

        /**
         * 删除时，操作ll2，有限制
         * @return
         */
        public int deleteHead() {
            if (!ll2.isEmpty()) return ll2.removeLast();
            if (ll1.isEmpty()) return -1;
            while (!ll1.isEmpty()){
                ll2.addLast(ll1.removeLast());
            }
            return ll2.removeLast();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
