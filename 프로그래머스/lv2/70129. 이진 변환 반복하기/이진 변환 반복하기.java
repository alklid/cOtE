class Solution {
    public int[] solution(String s) {
        int loopCount = 0;
        int removed = 0;

        while (!"1".equals(s)) {
            int prevLen = s.length();
            s = s.replace("0", "");
            removed += prevLen - s.length();

            s = Integer.toString(s.length(), 2);
            loopCount++;
        }

        return new int[]{loopCount, removed};
    }
}