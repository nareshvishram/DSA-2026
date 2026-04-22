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
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private int helper(TreeNode root, int depth) {
        if (root == null)
            return 0;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (root.left == null && root.right == null)
            return 1;
        if (Math.abs(left - right) > 1)
            ans = false;
        return Math.max(left, right) + 1;

    }
}