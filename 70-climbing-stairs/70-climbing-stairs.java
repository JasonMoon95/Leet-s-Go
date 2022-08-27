class Solution {
    static int solve[];
    static int solver(int n)
    {
        if(solve[n]!=0) return solve[n];
        solve[n] = solver(n-1) + solver(n-2);
        return solve[n];
    }

    static int climbStairs(int n) {
        solve = new int[46];
        solve[1] = 1;
        solve[2] = 2;
        return solver(n);
    }
}