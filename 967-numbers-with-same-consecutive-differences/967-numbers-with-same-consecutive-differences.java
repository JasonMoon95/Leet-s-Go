import java.util.ArrayList;

class Solution {
    void maker(int num, int diff, int depth, int dd, ArrayList<Integer> ans)
    {
        if(dd==depth)
        {
            ans.add(num);
            return;
        }
        int lastNum = num%10;
        if(lastNum+diff <10)
        {
            maker(num*10+lastNum+diff, diff, depth+1, dd, ans);
        }
        if(diff !=0 && lastNum-diff >= 0)
        {
            maker(num*10+lastNum-diff, diff, depth+1, dd, ans);
        }
        return;
    }
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<10; i++)
        {
            maker(i, k, 1, n, list);
        }
        int[] arr1 = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}