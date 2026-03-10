package Question3;
import java.util.Scanner;
import java.util.Stack;

public class ChronoStackEngine {
        public static String getInstructions(int targetValue) {
        Stack<String> operationStack = new Stack<>();
        int current = targetValue;
        while (current > 1) {
            if (current % 2 == 0) {
                operationStack.push("d+"); 
                current = current / 2;
            } else {
                operationStack.push("1+"); 
                current = current - 1;
            }
        }
        StringBuilder sb = new StringBuilder("1");
        while (!operationStack.isEmpty()) {
            sb.append(operationStack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input jumlah angka/elemen: ");
        int n = scanner.nextInt();
        int[] targetTimeline = new int[n];
        System.out.print("Input angka timeline (pisahkan dengan spasi): ");
        for (int i = 0; i < n; i++) {
            targetTimeline[i] = scanner.nextInt();
        }
        String[] instructionsArray = new String[n];
        int totalPluses = 0; 
        for (int i = n - 1; i >= 0; i--) {
            int targetVal = targetTimeline[i];
            int requiredValue = targetVal + totalPluses; 
            String inst = getInstructions(requiredValue);
            instructionsArray[i] = inst;
            int plusCount = 0;
            for (char c : inst.toCharArray()) {
                if (c == '+') plusCount++;
            }
            totalPluses += plusCount;
        }
        StringBuilder finalOutput = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalOutput.append(instructionsArray[i]);
        }
        System.out.println("Output:");
        System.out.println(finalOutput.toString());
        scanner.close();
    }
}