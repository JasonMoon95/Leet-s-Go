class Solution {
    public boolean isPowerOfThree(int n) {
        int res = n;
        if(n<=0) return false;
        while(res != 1)
        {
            if(res==0) return false;
            if((res%3) != 0) return false;
            res = res/3;
        }
        return true;
    }
}