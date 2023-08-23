class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(push(c, n));
        }

        return sb.toString();
    }
    
    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        // 시작 위치
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;

        // 거리 밀기
        position = position + n;

        // 'z' 또는 'Z' 를 넘어가면 다시 'a' 또는 'A' 부터 시작하기
        // 대소문자 갯수인 26개로 나눠서 나머지를 이용하는 방식)
        position = position % ('z' - 'a' + 1);

        return (char)(offset + position);
    }
}