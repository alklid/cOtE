class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] rankSort = new int[rank.length];
        for (int i=0; i<rank.length; i++) {
            rankSort[rank[i]-1] = i;
        }
        
        int top1 = -1;
        int top2 = -1;
        int top3 = -1;
        for (int i=0; i<rankSort.length; i++) {
            if (attendance[rankSort[i]]) {
                if (top1 == -1) {
                    top1 = rankSort[i];
                    continue;
                }
                if (top2 == -1) {
                    top2 = rankSort[i];
                    continue;
                }
                if (top3 == -1) {
                    top3 = rankSort[i];
                    break;
                }
            } 
        }
        
        int answer = (10000 * top1) + (100 * top2) + top3;
        return answer;
    }
}