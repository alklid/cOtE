class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String item : order) {
            String coffee = item.replace("ice", "")
                                .replace("hot", "")
                                .replace("anything", "americano");
            if (coffee.equals("americano")) {
                answer += 4500;
            }
            if (coffee.equals("cafelatte")) {
                answer += 5000;
            }
        }
        
        return answer;
    }
}