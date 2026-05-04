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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return getTree(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode getTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        int currRootVal = preorder[preIndex++];
        TreeNode currRoot = new TreeNode(currRootVal);
        int partition = map.get(currRootVal);
        currRoot.left = getTree(preorder, inorder, start, partition - 1);
        currRoot.right = getTree(preorder, inorder, partition + 1, end);
        return currRoot;

    }
}