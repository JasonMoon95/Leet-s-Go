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
    public int dfs(TreeNode node, int max, int cnt)
    {
        cnt = 0;
        if(node.val >= max)
        {
            cnt++;
            max = node.val;
        }
        if(node.left != null) cnt += dfs(node.left, max, cnt);
        if(node.right != null) cnt += dfs(node.right, max, cnt);
        return cnt;
    }
    public int goodNodes(TreeNode root) 
    {
        return dfs(root, root.val, 0);
    }
}