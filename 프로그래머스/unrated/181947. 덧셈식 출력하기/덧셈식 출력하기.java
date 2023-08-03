import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a < 1 || a > 100) {
            // bad parameter
        }
        
        if (b < 1 || b > 100) {
            // bad parameter
        }
        
        int c = a + b;
        System.out.printf("%d + %d = %d", a, b, c);
    }
}