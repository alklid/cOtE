import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int len = todo_list.length;
            
        String todo = "";
        for (int i=0; i<len; i++) {
            if (finished[i] == false) {
                todo += todo_list[i] + ",";
            }
        }
        
        String[] answer = todo.split(",");
        return answer;
    }
}