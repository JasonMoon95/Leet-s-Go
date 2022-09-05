import java.util.List;
import java.util.ArrayList;

class Solution {
    int depth = 1; //root
    public void dfs(Node node, int dd, ArrayList<ArrayList<Integer>> res)
    {
        if(node == null) return;
        res.get(dd).add(node.val);
        for(int i=0; i<node.children.size(); i++)
        {
            dfs(node.children.get(i), dd+1, res);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=10000; i++)
        {
            list.add(new ArrayList<Integer>());
        }
        dfs(root, 0, list);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<=10000; i++)
        {
            if(!list.get(i).isEmpty()) result.add(list.get(i));
        }
        return result;
    }
}
