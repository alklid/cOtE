class Solution {
    public int[] solution(int brown, int yellow) {
        int square = brown + yellow;
        for (int height=3; height<square; height++) {
            int width = square / height;
            if (square % height == 0 && width >= height) {
                if (isCarpet(brown, yellow, width, height)) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{};
    }
    
    private boolean isCarpet(int brown, int yellow, int width, int height) {
        return brown == ((width + height - 2) * 2) &&
            yellow == (width * height) - ((width + height - 2) * 2);
    }
}