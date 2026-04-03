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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder serializedString = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            int size = nodes.size();

            for(int i = 0; i < size; i++) {
                TreeNode currentNode = nodes.remove();
                serializedString.append(currentNode == null ? "null " : currentNode.val + " ");
                if(currentNode != null) {
                    nodes.add(currentNode.left);
                    nodes.add(currentNode.right);
                }
            }
        }

        return serializedString.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) {
            return null;
        }

        TreeNode root = null;
        String[] nodes = data.split(" ");
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(new TreeNode(Integer.parseInt(nodes[0])));
        int index = 1;

        while(!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = treeNodes.remove();
                if(root == null) {
                    root = currentNode;
                }

                if(currentNode != null) {
                    if(nodes[index].equals("null")) {
                        currentNode.left = null;
                    } else {
                        currentNode.left = new TreeNode(Integer.parseInt(nodes[index]));
                    }

                    index++;
                    treeNodes.add(currentNode.left);

                    if(nodes[index].equals("null")) {
                        currentNode.right = null;
                    } else {
                        currentNode.right = new TreeNode(Integer.parseInt(nodes[index]));
                    }

                    index++;
                    treeNodes.add(currentNode.right);
                }
            }
        }
 
        return root;
    }
}
