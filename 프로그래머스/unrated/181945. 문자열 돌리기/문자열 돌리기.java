import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        validation(a);
        
        for (char c : a.toCharArray()) {
            System.out.println(c);
        }
    }
    
    static void validation(String input) {
        int len = input.length();
        if (len < 1 || len > 10) {
            // bad input
        }
    }
}