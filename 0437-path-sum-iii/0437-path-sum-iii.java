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
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0l, 1L);
        helper(root, targetSum, 0l, map);
        return count;
    }

    private void helper(TreeNode root, int target, long curr, Map<Long, Long> map) {
        if (root == null)
            return;
        curr += root.val;
        count += map.getOrDefault(curr - target, 0L);
        map.put(curr, map.getOrDefault(curr, 0L) + 1);
        helper(root.left, target, curr, map);
        helper(root.right, target, curr, map);
        map.put(curr, map.getOrDefault(curr, 1L) - 1);

    }
}