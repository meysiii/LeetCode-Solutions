class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = 0;

        for (int[] s : squares) {
            int y = s[1];
            int l = s[2];

            totalArea += (double) l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = totalArea / 2.0;

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            if (areaBelow(squares, mid) >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    private double areaBelow(int[][] squares, double yLine) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];

            if (yLine <= y) {
                continue;
            } else if (yLine >= y + l) {
                area += l * l;
            } else {
                area += (yLine - y) * l;
            }
        }

        return area;
    }
}