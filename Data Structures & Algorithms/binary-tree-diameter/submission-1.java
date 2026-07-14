/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxHeight(TreeNode root){
        if(root == null)
            return 0;
        int left = 1 + maxHeight(root.left);
        int right = 1 + maxHeight(root.right);

        return Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int res = 0;
        Stack<TreeNode> st = new Stack<>();

        if(root == null)
            return 0;
        
        TreeNode curr = root;
        while(curr != null || !st.empty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            int leftMaxHeight = 0, rightMaxHeight = 0;
            if(curr != null)
                res = Math.max(res, maxHeight(curr.left) + maxHeight(curr.right));
            curr = curr.right;
        }
        return res;
    }
}
