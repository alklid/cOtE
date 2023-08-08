class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for (int i=0; i<picture.length; i++) {
            
        }
        for (int i=0; i<picture.length; i++) {
            int zoomInCount = 0;
            while (zoomInCount < k) {
                String zoomInPicture = zoonInPicture(picture[i], k);
                answer[i*k+zoomInCount] = zoomInPicture;
                zoomInCount++;
            }
        }
        return answer;
    }
    
    static String zoonInPicture(String picture, int zoomInRatio) {
        StringBuffer sb = new StringBuffer();
        for (String pic : picture.split("")) {
            sb.append(pic.repeat(zoomInRatio));
        }
        return sb.toString();
    }
}