import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int[] cnt = new int[100001];
    int[] empty = new int[0];
    public int[] findOriginalArray(int[] changed) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(changed);
        for(int i=0; i<changed.length; i++)
        {
            cnt[changed[i]]++;
        }
        for(int i=0; i<changed.length; i++)
        {
            if(cnt[changed[i]]>0)
            {
                cnt[changed[i]]--;
                if(changed[i]*2 > 100000) return empty;
                if(cnt[changed[i]*2] > 0) 
                {
                    res.add(changed[i]);
                    cnt[changed[i]*2]--;
                }
                else return empty;
            }
        }
        int[] arr = res.stream()
        .mapToInt(Integer::intValue)
            .toArray();
        return arr;
    }
}