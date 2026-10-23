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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, i.e same right
        if(p == null && q == null)
            return true;

        // either of them is null, both doesn't match
        if(p == null || q == null)
            return false;
        
        // both are not null, then checking their values, if doesn't match - not same
        if(p != null && q != null && p.val != q.val)
            return false;

        // once we have both left and right results, both should match
        // java - only true && true is true.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
