class Solution {
    
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            
            // Update minimum buying price
            minPrice = Math.min(minPrice, price);
            
            // Calculate profit
            int profit = price - minPrice;
            
            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}