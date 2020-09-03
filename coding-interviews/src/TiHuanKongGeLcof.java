//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// 👍 39 👎 0

// 替换空格
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        // 字符串的不可变，String对象是不可变的
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String s="We are happy.";
        char[] c = new char[30];
        for (int i=0;i<s.length();i++){
            c[i]=s.charAt(i);
        }
        solution.replaceSpace(c);
        StringBuffer sb=new StringBuffer("We are happy.");
        System.out.println(solution.replaceSpace(sb));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //先计算长度，再从后向前复制，复杂度O(n)
        public String replaceSpace(char[] s) {
            replaceBlank(s);
            String s1=String.valueOf(s).split("\0")[0];
            System.out.println(s1);
            System.out.println(new String(s).split("\0")[0]);
            return new String(s).split("\0")[0];
        }

        public String replaceSpace(StringBuffer str) {
            int oldLen = str.length() - 1;
            for(int i = 0; i <= oldLen; i++){
                if(str.charAt(i) == ' '){
                    //添加两个空格
                    str.append("  ");
                }
            }
            int newLen = str.length() - 1;
            while(newLen > oldLen && oldLen >= 0){
                char c = str.charAt(oldLen--);
                if(c == ' '){
                    str.setCharAt(newLen--, '0');
                    str.setCharAt(newLen--, '2');
                    str.setCharAt(newLen--, '%');
                }else{
                    str.setCharAt(newLen--, c);
                }
            }
            return str.toString();
        }
        /**
         * string 用 '\0' 作为字符串结束标志
         * @param string 字符数组
         */
        public void replaceBlank(char[] string) {
            if (string == null || string.length == 0) {
                return;
            }
            //统计长度
            int oldLen = 0;
            int numOfBlank = 0;
            for (int i = 0; i < string.length && string[i] != '\0'; ++i) {
                ++oldLen;
                if (string[i] == ' ') {
                    ++numOfBlank;
                }
            }
            // newLen 为把空格替换成 '%20' 之后的长度
            int newLen = oldLen + 2 * numOfBlank;
            if (newLen > string.length) {
                // string 数组不够容纳替换之后的所有字符
                return;
            }

            int indexOfOld = oldLen; // 指向字符串结束标志 '\0'
            int indexOfNew = newLen;
            while (indexOfNew > indexOfOld) {
                if (string[indexOfOld] != ' ') {
                    string[indexOfNew--] = string[indexOfOld--];
                } else {
                    --indexOfOld;
                    string[indexOfNew--] = '0';
                    string[indexOfNew--] = '2';
                    string[indexOfNew--] = '%';
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
