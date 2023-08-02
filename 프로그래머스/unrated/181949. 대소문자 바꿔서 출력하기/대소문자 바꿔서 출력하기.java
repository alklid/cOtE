import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        int strLen = a.length();
        if (strLen < 1 || strLen > 20) {
            // bad parameter
        }
        
        char[] charArr = a.toCharArray();
        for (int i=0; i<charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                charArr[i] = Character.toLowerCase(charArr[i]);
            }
            else {
                charArr[i] = Character.toUpperCase(charArr[i]);
            }
        }
        
        System.out.print(new String(charArr));
        
        sc.close();
    }
}