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
    private int diameter = Integer.MIN_VALUE;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return diameter - 1;
    }
    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSubTreeHeight = diameterOfBinaryTreeHelper(root.left);
        int rightSubTreeHeight = diameterOfBinaryTreeHelper(root.right);
        int currentDiameter = leftSubTreeHeight + rightSubTreeHeight + 1;

        diameter = Math.max(diameter, currentDiameter);

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;        
    }
}
