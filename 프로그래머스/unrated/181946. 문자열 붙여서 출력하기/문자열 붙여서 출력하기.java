import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        int aLen = a.length();
        int bLen = b.length();
        
        if (aLen < 1 || aLen > 10) {
            // bad input
        }
        
        if (bLen < 1 || bLen > 10) {
            // bad input
        }
        
        System.out.printf("%s%s", a, b);
    }
}