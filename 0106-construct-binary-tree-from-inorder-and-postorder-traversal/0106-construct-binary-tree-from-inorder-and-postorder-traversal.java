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
    int postIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return getTree(inorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode getTree(int[] inorder, int[] postorder, int start, int end) {
        if (start > end || postIndex < 0)
            return null;
        int curr = postorder[postIndex--];
        TreeNode currNode = new TreeNode(curr);
        int partition = map.get(curr);
        currNode.right = getTree(inorder, postorder, partition + 1, end);
        currNode.left = getTree(inorder, postorder, start, partition - 1);
        return currNode;
    }
}