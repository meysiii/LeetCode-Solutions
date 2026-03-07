class Solution {
    public double myPow(double x, int n) {
        long N = n; // use long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        double result = 1.0;
        double current_product = x;
        
        while (n > 0) {
            if ((n % 2) == 1) { // if n is odd
                result *= current_product;
            }
            current_product *= current_product; // square the base
            n /= 2;
        }
        
        return result;
    }
}