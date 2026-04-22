/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = null, right = null;
        if (root.val < p.val && root.val < q.val)
            right = lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            left = lowestCommonAncestor(root.left, p, q);
        else if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
            return root;
        if (left != null && right != null)
            return root;

        return left != null ? left : right;

    }

    public TreeNode lowestCommonAncestorNormal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null)
            return right;
        if (right == null && left != null)
            return left;
        if (left != null && right != null)
            return root;
        return null;
    }
}