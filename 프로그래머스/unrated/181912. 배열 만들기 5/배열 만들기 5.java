import java.util.stream.Stream;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        /*
        int[] answer = Stream.of(intStrs)
                        .mapToInt(n -> Integer.valueOf(n.substring(s, s+l)))
                        .filter(n -> n > k)
                        .toArray();
        return answer;
        */
        
        ArrayList<Integer> list = new ArrayList<>();

        for (String val : intStrs) {
            int num = Integer.parseInt(val.substring(s, s + l));
            if (k < num) {
                list.add(num);
            }
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}