package Question1;
import java.util.Scanner;
import java.util.Stack;

public class BracketChecker {
    public static String is_balanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return "Is not balanced";
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return "Is not balanced";
                }
            }
        }
        return stack.isEmpty() ? "Is balanced" : "Is not balanced";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan string kurung (contoh: {[()]}): ");
        if (sc.hasNextLine()) {
            String input = sc.nextLine();
            System.out.println("Output: " + is_balanced(input));
        }
        sc.close();
    }
}