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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean[] result = new boolean[1];
        result[0] = true;

        isBalancedHelper(root, result);

        return result[0];
    }
    private int isBalancedHelper(TreeNode root, boolean[] result) {
        if(root == null) {
            return 0;
        }

        int left = isBalancedHelper(root.left, result);
        int right = isBalancedHelper(root.right, result);

        if(Math.abs(left - right) > 1) {
            result[0] = false;
        }

        return Math.max(left, right) + 1;
    }
}
