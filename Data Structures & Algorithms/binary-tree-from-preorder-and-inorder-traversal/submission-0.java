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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderLookup = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderLookup.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, new int[]{0}, 0, inorder.length - 1, inorderLookup);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int[] startIndex, int start, int end, HashMap<Integer, Integer> inorderLookup) {
        if(start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startIndex[0]]);
        startIndex[0]++;
        root.left = buildTreeHelper(preorder, inorder, startIndex, start, inorderLookup.get(root.val) - 1, inorderLookup);
        root.right = buildTreeHelper(preorder, inorder, startIndex, inorderLookup.get(root.val) + 1, end, inorderLookup);

        return root;
    }
}
