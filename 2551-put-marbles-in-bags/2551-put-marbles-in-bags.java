class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] costs = new int[weights.length - 1];
        for (int i = 0; i < costs.length; ++i) {
            costs[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(costs);
        long min = 0;
        long max = 0;
        for (int i = 0; i < k - 1; ++i) {
            max += costs[costs.length - 1 - i];
            min += costs[i];
        }
        return max-min;
    }
}