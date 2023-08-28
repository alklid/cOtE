import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        // 순열 만들기
        String[] result = new String[user_id.length];
        boolean[] visited = new boolean[user_id.length];
        Set<String> permList = new HashSet<>();
        for (int i=0; i<user_id.length; i++) {
            permutation(user_id, result, visited, 0, i+1, banned_id.length, permList);
        }

        // 조합중에서 banned_id 패턴과 일치여부 확인
        Set<String> bannedList = new HashSet<>();
        for (String perm : permList) {
            String[] ids = perm.split(" ");
            if (isBanned(ids, banned_id)) {
                Arrays.sort(ids);
                bannedList.add(Arrays.toString(ids));
            }
        }

        return bannedList.size();
    }
    
    private boolean isBanned(String[] ids, String[] banned_id) {
        boolean isBanned = true;

        for (int i=0; i<banned_id.length; i++) {
            if (!ids[i].matches(banned_id[i].replace("*", "."))) {
                isBanned = false;
                break;
            }
        }

        return isBanned;
    }

    // 순열 만들기
    private void permutation(String[] nums, String[] result, boolean[] visited, int depth, int lv, int bannedLen, Set<String> permList) {
        if (depth == lv) {
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<lv; i++) {
                sb.append(result[i] + " ");
            }
            if (depth == bannedLen) {
                permList.add(sb.toString());
            }
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = nums[i];
                permutation(nums, result, visited, depth + 1, lv, bannedLen, permList);
                visited[i] = false;
            }
        }
    }
}