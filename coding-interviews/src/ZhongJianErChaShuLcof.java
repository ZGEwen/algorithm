//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 188 👎 0


// 重建二叉树
public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
                return null;
            }

            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        /**
         * @param preorder  前序遍历数组
         * @param preSIndex 前序遍历开始下标
         * @param preEIndex 前序遍历终止下标
         * @param inorder   中序遍历数组
         * @param inSIndex  中序遍历开始下标
         * @param inEIndex  中序遍历终止下标
         * @return
         */
        private TreeNode buildTree(int[] preorder, int preSIndex, int preEIndex, int[] inorder, int inSIndex, int inEIndex) {
            if (preSIndex > preEIndex || inSIndex > inEIndex) return null;
            //    查找根节点(前序的第一个节点)在中序中的位置，左子树-根-右子数
            //    查找方法，遍历查找或根据数字唯一不重复使用哈希表
            int rootIndex = findRootIndexIn(inorder, inSIndex, inEIndex, preorder[preSIndex]);
            //    构建树的根节点
            TreeNode tree = new TreeNode(preorder[preSIndex]);
            //    递归创建左子树,左子树长度为 rootIndex-inSIndex
            tree.left = buildTree(preorder, preSIndex + 1, preSIndex + rootIndex - inSIndex, inorder, inSIndex, rootIndex - 1);
            //    递归创建右子树,右子树长度为 inEIndex-rootIndex
            tree.right = buildTree(preorder, preSIndex + rootIndex - inSIndex + 1, preEIndex, inorder, rootIndex + 1, inEIndex);
            //    返回构建的树
            return tree;
        }

        private int findRootIndexIn(int[] inorder, int inSIndex, int inEIndex, int rootVal) {
            for (int i = inSIndex; i <= inEIndex; i++) {
                if (inorder[i] == rootVal) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
