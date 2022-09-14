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
    int res = 0;
    int isPalin(int[] counter)
    {
        int oddCnt = 0;
        for(int i=1; i<10; i++)
        {
            if(counter[i]%2 >0) oddCnt++;
        }
        if(oddCnt >1) return 0;
        return 1;
    }
    void dfs(int[] counter, TreeNode node)
    {
        if(node.left == null && node.right == null)
        {
            res += isPalin(counter);
        }
        if(node.left != null)
        {
            counter[node.left.val]++;
            dfs(counter, node.left);
            counter[node.left.val]--;
        }
        if(node.right != null)
        {
            counter[node.right.val]++;
            dfs(counter, node.right);
            counter[node.right.val]--;
        }
    }
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] counter = new int[10];
        counter[root.val]++;
        dfs(counter, root);
        return res;
    }
}