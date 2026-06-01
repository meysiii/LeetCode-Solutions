class Solution {

    class Event {
        long y;
        int type;
        long x1;
        long x2;

        Event(long y, int type, long x1, long x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    List<Long> xs = new ArrayList<>();
    long[] count;
    double[] len;

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x1 = s[0];
            long y1 = s[1];
            long l = s[2];

            long x2 = x1 + l;
            long y2 = y1 + l;

            xs.add(x1);
            xs.add(x2);

            events.add(new Event(y1, 1, x1, x2));
            events.add(new Event(y2, -1, x1, x2));
        }

        Collections.sort(xs);
        xs = new ArrayList<>(new LinkedHashSet<>(xs));

        events.sort((a, b) -> Long.compare(a.y, b.y));

        int m = xs.size();

        count = new long[m * 4];
        len = new double[m * 4];

        double totalArea = 0;
        long prevY = events.get(0).y;

        List<double[]> strips = new ArrayList<>();

        for (Event e : events) {
            long currY = e.y;

            double covered = len[1];

            if (currY > prevY) {
                double area = covered * (currY - prevY);

                strips.add(new double[]{prevY, currY, covered, totalArea});

                totalArea += area;
            }

            int l = lowerBound(xs, e.x1);
            int r = lowerBound(xs, e.x2) - 1;

            update(1, 0, m - 2, l, r, e.type);

            prevY = currY;
        }

        double half = totalArea / 2.0;

        for (double[] s : strips) {
            double y1 = s[0];
            double y2 = s[1];
            double width = s[2];
            double prefix = s[3];

            double area = width * (y2 - y1);

            if (prefix + area >= half) {
                return y1 + (half - prefix) / width;
            }
        }

        return 0;
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (r < start || end < l) {
            return;
        }

        if (l <= start && end <= r) {
            count[node] += val;
        } else {
            int mid = (start + end) / 2;

            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);
        }

        if (count[node] > 0) {
            len[node] = xs.get(end + 1) - xs.get(start);
        } else if (start == end) {
            len[node] = 0;
        } else {
            len[node] = len[node * 2] + len[node * 2 + 1];
        }
    }

    private int lowerBound(List<Long> arr, long target) {
        int l = 0;
        int r = arr.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}