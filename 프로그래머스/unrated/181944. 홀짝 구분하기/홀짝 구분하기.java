import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        validation(n);
        
        String evenOrOdd = "even";
        if (n == 1 || n % 2 == 1) {
            evenOrOdd = "odd";
        }
        
        System.out.printf("%d is %s", n, evenOrOdd);
    }
    
    static void validation(int input) {
        if (input < 1 || input > 1000) {
            // bad input
        }
    }
}