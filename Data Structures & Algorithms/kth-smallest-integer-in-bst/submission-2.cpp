/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    void traverse(TreeNode* root, int& k, int& res){
        if(root == nullptr){
            return;
        }
        traverse(root -> left, k, res);

        k--;
        if(k == 0){
            res = root -> val;
            return;
        }
        traverse(root -> right, k, res);
    }

    int kthSmallest(TreeNode* root, int k) {
        int result = -1;
        traverse(root, k, result);
        return result;
    }
};
