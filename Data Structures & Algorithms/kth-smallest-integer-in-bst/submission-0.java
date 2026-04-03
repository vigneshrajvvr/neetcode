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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> allNodes = new ArrayList<>();
        inorderTraversal(root, allNodes);
        return allNodes.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> allNodes) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left, allNodes);
        allNodes.add(root.val);
        inorderTraversal(root.right, allNodes);
    }
}
