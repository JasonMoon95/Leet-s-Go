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
    void inorderSearch(TreeNode node, List<Integer> list)
    {
        if(node == null) return;
        if(node.left != null) inorderSearch(node.left, list);
        list.add(node.val);
        if(node.right != null) inorderSearch(node.right, list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderSearch(root, res);
        return res;
    }
}