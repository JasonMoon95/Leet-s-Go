import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    void search(TreeNode node, int num, int depth, ArrayList<ArrayList<Integer>> arr)
    {
        arr.get(num+10).add(node.val+(10000*depth));

        if(node.left != null) search(node.left, num-1, depth+1, arr);
        if(node.right != null) search(node.right, num+1, depth+1, arr);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<21; i++)
        {
            arr.add(new ArrayList<Integer>());
        }
        search(root, 0, 0, arr);
        for(int i=0; i<21; i++)
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            if(!arr.get(i).isEmpty())
            {
                Collections.sort(arr.get(i));
                for(int j=0; j<arr.get(i).size(); j++)
                {
                    tmp.add(arr.get(i).get(j)%10000);
                }
                list.add(tmp);
            }
        }
        return list;
    }
}
