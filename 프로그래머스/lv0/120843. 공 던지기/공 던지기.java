class Solution {
    public int solution(int[] numbers, int k) {
        // 공을 받는 사람 순서를 찾고 (k * 2)
        // 공을 던지는 사람 순서로 변경 ((K -1) * 2)
        // 순환되는 구조이므로 나머지를 통해 위치를 찾음 % numbers.length
        return numbers[((k - 1) * 2) % numbers.length];
    }
}