class Solution {
    boolean searchAndDelete(TreeNode node)
    {
        if(node.left != null)
        {
            if(searchAndDelete(node.left) == false) node.left = null;
        }
        if(node.right != null)
        {
            if(searchAndDelete(node.right) == false) node.right = null;
        }
        if(node.val == 0 && node.left == null && node.right == null) return false;

        return true;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(searchAndDelete(root) == false) root = null;
        return root;
    }
}