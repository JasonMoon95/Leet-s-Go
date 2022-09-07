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
    String makeString(String s, TreeNode node)
    {
        s = s+(int)(node.val);
        if(node.left == null && node.right == null) return s;
        if(node.left == null) s = s+"()";
        else
        {
            s = s+'(';
            s = makeString(s, node.left);
            s = s+')';
        }

        if(node.right == null) {}
        else
        {
            s = s+'(';
            s = makeString(s, node.right);
            s = s+')';
        }
        return s;
    }
    public String tree2str(TreeNode root) {
        String res = new String();
        res = makeString(res, root);
        
        return res;
    }
}