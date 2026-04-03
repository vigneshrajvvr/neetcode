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
    public int maxPathSum(TreeNode root) {
        int ans[] = new int[] {Integer.MIN_VALUE};
        maxPathSumHelper(root, ans);
        return ans[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] ans) {
        if(root == null) {
            return 0;
        }        
        int leftSum = maxPathSumHelper(root.left, ans);
        int rightSum = maxPathSumHelper(root.right, ans);

        int maxSum = root.val;
        maxSum = Math.max(maxSum, root.val + leftSum);
        maxSum = Math.max(maxSum, root.val + rightSum);

        ans[0] = Math.max(maxSum, ans[0]);
        ans[0] = Math.max(ans[0], root.val + leftSum + rightSum);
        return maxSum;
    }
}
