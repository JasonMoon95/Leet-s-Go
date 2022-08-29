class Solution {
    int[][] visit = new int[300][300];
    int[] sdarray = new int[90000];
    int vert;
    int hor;
    int res = 0;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public void dfs(int x, int y, char[][] grid, int sd)
    {
        int cnt=0;
        for(int k=0; k<4; k++)
        {         
            if( (x+dx[k] < 0) ||
                (y+dy[k] < 0) ||
                (x+dx[k] >= vert) ||
                (y+dy[k] >= hor) ||
                (grid[x+dx[k]][y+dy[k]] == '0') ||
                (visit[x+dx[k]][y+dy[k]] == 1))
            {
                cnt++;
                continue;
            }
            else
            {
                visit[x+dx[k]][y+dy[k]] = 1;
                dfs(x+dx[k], y+dy[k], grid, sd);
            }
        }
        if(cnt==4) 
        {
            //System.out.println(x+", "+y+"\n");
            if(sdarray[sd] != 1)
            {
                sdarray[sd] = 1;
                res++;
            }
        }
    }
    public int numIslands(char[][] grid) {
        vert = grid.length;
        hor = grid[0].length;
        int seed=0;
        for(int i=0; i<vert; i++)
        {
            for(int j=0; j<hor; j++)
            {
                if((grid[i][j] == '0') ||
                   (visit[i][j] == 1))
                {
                    continue;
                }
                dfs(i,j,grid, seed++);
            }
        }
        return res;
    }
}