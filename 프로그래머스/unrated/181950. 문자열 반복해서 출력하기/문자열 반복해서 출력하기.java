import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        int strLen = str.length();
        if (strLen < 1 || strLen > 10) {
            // bad parameter
        }
        if (n < 1 || n > 5) {
            // bad parameter
        }
        
        for (int i=0; i<n; i++) {
            System.out.print(str);
        }
        
        sc.close();
    }
}