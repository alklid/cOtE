class Solution {
    public int solution(String s) {
        int minCompressSize = Integer.MAX_VALUE;
        for (int length=1; length<=s.length(); length++) {
            // 길이만큼 자른 문자 배열 구하기
            String[] split = splitWord(s, length);

            // 압축된 문자열 구하기
            String compress = compress(split);
            minCompressSize = Math.min(minCompressSize, compress.length());

        }

        return minCompressSize;
    }
    
    private String[] splitWord(String s, int length) {
        int splitSize = (s.length() / length) + ((s.length() % length != 0) ? 1 : 0);
        String[] split = new String[splitSize];

        for (int i=0; i<split.length; i++) {
            int startIdx = i * length;
            int endIdx = Math.min((i * length) + length, s.length());

            String word = s.substring(startIdx, endIdx);
            split[i] = word;
        }
        return split;
    }

    private String compress(String[] split) {
        StringBuffer sb = new StringBuffer();

        for (int i=0; i<split.length; i++) {
            if (split[i].isEmpty()) {
                continue;
            }

            String word = split[i];
            int compCount = 1;
            for (int j=i+1; j<split.length; j++) {
                if (word.equals(split[j])) {
                    compCount++;
                    split[j] = "";
                }
                else {
                    break;
                }
            }

            if (compCount != 1) {
                sb.append(compCount);
            }
            sb.append(word);
        }

        return sb.toString();
    }
}