import java.util.*;

class Solution {
    public String solution(String letter) {
        Map<String, String> morseMap = new HashMap<>();
        morseMap.put(".-","a");
        morseMap.put("-...","b");
        morseMap.put("-.-.","c");
        morseMap.put("-..","d");
        morseMap.put(".","e");
        morseMap.put("..-.","f");
        morseMap.put("--.","g");
        morseMap.put("....","h");
        morseMap.put("..","i");
        morseMap.put(".---","j");
        morseMap.put("-.-","k");
        morseMap.put(".-..","l");
        morseMap.put("--","m");
        morseMap.put("-.","n");
        morseMap.put("---","o");
        morseMap.put(".--.","p");
        morseMap.put("--.-","q");
        morseMap.put(".-.","r");
        morseMap.put("...","s");
        morseMap.put("-","t");
        morseMap.put("..-","u");
        morseMap.put("...-","v");
        morseMap.put(".--","w");
        morseMap.put("-..-","x");
        morseMap.put("-.--","y");
        morseMap.put("--..","z");    
        
        String[] arr = letter.split(" ");
        for (int i=0; i<arr.length; i++) {
            arr[i] = morseMap.getOrDefault(arr[i], "");
        }
        
        String answer = String.join("", arr);
        return answer;
    }
}