class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < m; j++) {
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int totalFinish = waterStart + waterDuration[j];

                ans = Math.min(ans, totalFinish);
            }
        }

        for (int j = 0; j < m; j++) {
            int waterFinish = waterStartTime[j] + waterDuration[j];

            for (int i = 0; i < n; i++) {
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int totalFinish = landStart + landDuration[i];

                ans = Math.min(ans, totalFinish);
            }
        }

        return ans;
    }
}