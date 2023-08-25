import java.util.Locale;

class Solution {
    public String solution(String new_id) {
        // step1
        String answer = new_id.toLowerCase(Locale.ROOT);

        // step2
        answer = answer.replaceAll("[^a-z0-9\\-_.]", "");

        // step3
        answer = answer.replaceAll("\\.{2,}", ".");

        // step4
        answer = answer.replaceAll("^\\.+|\\.+$", "");

        // step5
        answer = answer.isEmpty() ? "a" : answer;

        // step6
        answer = answer.length() >= 16 ? answer.substring(0, 15).replaceAll("\\.+$", "") : answer;

        // step7
        answer = answer.length() > 2 ? answer : answer.concat(answer.substring(answer.length()-1).repeat(3-answer.length()));

        return answer;
    }
}