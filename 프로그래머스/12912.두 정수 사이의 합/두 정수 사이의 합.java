class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long min = Math.min(a, b);
        long max = Math.max(a, b);

        return (min + max) * (max - min + 1) / 2;
    }
}
