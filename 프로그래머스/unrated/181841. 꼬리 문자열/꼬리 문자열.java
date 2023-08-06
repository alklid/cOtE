class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuffer addStr = new StringBuffer();
        for (String str : str_list) {
            if (!str.contains(ex)) {
                addStr.append(str);
            }
        }
        String answer = addStr.toString();
        return answer;
    }
}