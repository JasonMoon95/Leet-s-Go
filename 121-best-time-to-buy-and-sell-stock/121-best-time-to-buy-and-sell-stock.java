class Solution {
    public int maxProfit(int[] prices) {
        int min = 10001;
        int dif;
        int maxdif = 0;
        for(int i=0; i<prices.length; i++)
        {
            if(prices[i]<min) min = prices[i];
            dif = prices[i]-min;
            if(dif>maxdif) maxdif = dif;
        }
        return maxdif;
    }
}