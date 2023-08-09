class Solution {
    public String solution(int age) {
        char[] ageArr = String.valueOf(age).toCharArray();
        for (int i=0; i<ageArr.length; i++) {
            ageArr[i] += '1';
        }
        return new String(ageArr);
    }
}