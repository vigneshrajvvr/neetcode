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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if(root == null) {
            return nodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = queue.remove();
                currentLevelNodes.add(currentNode.val);

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                } 

                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            nodes.add(currentLevelNodes);
        }

        return nodes;
    }
}
