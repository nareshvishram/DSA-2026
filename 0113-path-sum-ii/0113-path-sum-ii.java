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
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int target, int sum, List<Integer> tmp) {
        if (root == null)
            return;
        sum += root.val;
        tmp.add(root.val);
        //System.out.println(new ArrayList<>(tmp));
        if (sum == target && root.left == null && root.right == null)
            ans.add(new ArrayList<>(tmp));
        helper(root.left, target, sum, tmp);
        helper(root.right, target, sum, tmp);
        tmp.remove(tmp.size() - 1);
    }
}