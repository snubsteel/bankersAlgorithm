import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of processes and resources in the format x x: ");
        int numberOfProcesses = scanner.nextInt();
        int numberOfResources = scanner.nextInt();

        int[][] allocation = new int[numberOfProcesses][numberOfResources];
        System.out.println("Enter allocation matrix in the format x x x then, enter after each inputline -->");
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                allocation[i][j] = scanner.nextInt();
            }
        }

        int[][] maximum = new int[numberOfProcesses][numberOfResources];
        System.out.println("Enter max matrix in the format x x x then, enter after each inputline -->");
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                maximum[i][j] = scanner.nextInt();
            }
        }

        int[] available = new int[numberOfResources];
        System.out.println("Enter available matrix in the format x x x -->");
        for (int i = 0; i < numberOfResources; i++) {
            available[i] = scanner.nextInt();
        }

        BankersAlgorithm bankersAlgorithm = new BankersAlgorithm(numberOfResources, numberOfProcesses, available, maximum, allocation);

        if (bankersAlgorithm.isSafe()) {
            System.out.println("Safely allocated");
        } else {
            System.out.println("The system is not in a safe state.");
        }

        scanner.close();
    }
}
