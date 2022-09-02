import java.util.List;
import java.util.ArrayList;

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
    double[] cnt = new double[10000];
    double[] total = new double[10000];
    int dp =0;
    public void dfs(TreeNode node, int depth)
    {
        if(dp<depth) dp = depth;
        cnt[depth]++;
        total[depth] += node.val;

        if(node.left != null) dfs(node.left, depth+1);
        if(node.right != null) dfs(node.right, depth+1);
        return ;
    }
    public List<Double> averageOfLevels(TreeNode root) 
    {
        ArrayList<Double> ll = new ArrayList<Double>();
        dfs(root, 0);
        for(int i=0; i<=dp; i++)
        {
            ll.add(total[i]/cnt[i]);
        }
        return ll;
    }
}