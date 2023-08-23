class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpperCase = true;

        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                sb.append(c);
                toUpperCase = true;
            }
            else {
                if (toUpperCase) {
                    sb.append(Character.toUpperCase(c));
                }
                else {
                    sb.append(Character.toLowerCase(c));
                }
                toUpperCase = !toUpperCase;
            }
        }

        return sb.toString();
    }
}