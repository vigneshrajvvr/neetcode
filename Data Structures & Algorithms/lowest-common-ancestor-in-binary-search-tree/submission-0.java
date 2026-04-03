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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode traversalNode = root;

        while(traversalNode != null) {
            if(traversalNode.val > p.val && traversalNode.val > q.val) {
                traversalNode = traversalNode.left;
            } else if(traversalNode.val < p.val && traversalNode.val < q.val) {
                traversalNode = traversalNode.right;
            } else {
                return traversalNode;
            }
        }

        return null;
    }
}
