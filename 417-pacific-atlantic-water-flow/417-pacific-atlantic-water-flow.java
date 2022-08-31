import java.util.List;
import java.util.ArrayList;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] visit = new int[201][201];
    int[][][] res = new int[201][201][2];
    int N;
    int M;
    void dfs(int x, int y, int orgx, int orgy, int[][] heights)
    {
                if(res[orgx][orgy][0] == 1 &&
           res[orgx][orgy][1] == 1) return ;
        visit[x][y] = 1;
        if(x == 0 || y == 0)
        {
            //pacific
            res[orgx][orgy][0] = 1;
            //System.out.println("dd "+orgx+" "+orgy+"\n");
            
        }
        if(x == N-1 || y == M-1)
        {
            //atlantic
            res[orgx][orgy][1] = 1;
            //System.out.println("aa "+orgx+" "+orgy+"\n");
        }

        for(int i=0; i<4; i++)
        {
            int xx = x+dx[i];
            int yy = y+dy[i];
            if(xx>=0 &&
            xx<N &&
            yy>=0 &&
            yy<M &&
            (visit[xx][yy] != 1) &&
                (heights[x][y]>=heights[xx][yy]))
            {
                dfs(x+dx[i], y+dy[i], orgx, orgy,heights);
            }
        }

        visit[x][y] = 0;
        return ;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        N = heights.length;
        M = heights[0].length;
        List<Integer> w = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                dfs(i,j,i,j,heights);
                if(res[i][j][0] == 1 &&
                   res[i][j][1] == 1)
                   {
                    w.add(i);
                    w.add(j);
                    list.add(new ArrayList(w));
                    w.clear();
                    //System.out.println("ddddd "+i+" "+j+"\n");

                   }
            }
        }
        return list;
    }
}
