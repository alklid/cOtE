import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        validation(n);
        
        System.out.printf("%d is %s", n, (n % 2 == 0) ? "even" : "odd");
    }
    
    static void validation(int input) {
        if (input < 1 || input > 1000) {
            // bad input
        }
    }
}