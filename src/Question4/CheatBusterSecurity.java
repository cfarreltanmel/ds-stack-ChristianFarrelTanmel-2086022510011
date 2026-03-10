package Question4;
import java.util.Scanner;
import java.util.Stack;

public class CheatBusterSecurity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan deret angka (pisahkan dengan spasi): ");
        
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strNums = line.split(" ");
            Stack<Integer> originalStack = new Stack<>();
            
            for (String s : strNums) {
                try {
                    originalStack.push(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    // Abaikan jika user memasukkan spasi berlebih
                }
            }

            Stack<Integer> sortedStack = new Stack<>();
            while (!originalStack.isEmpty()) {
                int temp = originalStack.pop();
                while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                    originalStack.push(sortedStack.pop());
                }
                sortedStack.push(temp);
            }
            System.out.print("Output: ");
            for (int num : sortedStack) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}