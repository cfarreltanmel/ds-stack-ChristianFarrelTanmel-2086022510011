package Question5;
import java.util.Scanner;
import java.util.Stack;

public class OperationChastise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input momentum: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            Stack<Integer> bounces = new Stack<>();
            while (n > 0) {
                bounces.push(n);
                n /= 2;
            }
            boolean first = true;
            while (!bounces.isEmpty()) {
                if (!first) {
                    System.out.print(" ");
                }
                System.out.print(bounces.pop());
                first = false;
            }
            System.out.println();
        }
        sc.close();
    }
}