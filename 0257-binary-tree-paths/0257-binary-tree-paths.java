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
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        traverse(root, "");
        return ans;
    }

    private void traverse(TreeNode root, String str) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(str + root.val);
        }

        str = str + root.val + "->";
        //System.out.println(str);
        traverse(root.left, str);
        traverse(root.right, str);

    }
}