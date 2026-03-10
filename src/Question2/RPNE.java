package Question2;
import java.util.Scanner;
import java.util.Stack;

public class RPNE {
    public static int evaluate_rpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    int bMinus = stack.pop();
                    int aMinus = stack.pop();
                    stack.push(aMinus - bMinus);
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan RPN (pisahkan dengan spasi, contoh: 4 13 + 5 /): ");
        if (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] tokens = input.split(" ");
            System.out.println("Output: " + evaluate_rpn(tokens));
        }
        sc.close();
    }
}