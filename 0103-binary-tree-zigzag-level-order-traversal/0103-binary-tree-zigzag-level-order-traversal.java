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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int level = 0;
        q.add(root);
        if (root == null)
            return ans;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                if (level % 2 != 0)
                    dq.addFirst(curr.val);
                else
                    dq.addLast(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
           // System.out.println(dq);
            List<Integer> l = new ArrayList<>();
            while (!dq.isEmpty()) {
                l.add(dq.pollFirst());
            }
            ans.add(l);
            level++;
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrderReverseList(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int level = 0;
        q.add(root);
        if (root == null)
            return ans;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                l.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            if (level % 2 != 0)
                Collections.reverse(l);
            ans.add(l);
            level++;
        }
        return ans;
    }
}