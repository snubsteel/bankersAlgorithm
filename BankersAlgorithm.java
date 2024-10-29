import java.util.*;

public class BankersAlgorithm {
    private int numberOfResources;
    private int numberOfProcesses;
    private int[] available;
    private int[][] maximum;
    private int[][] allocation;
    private int[][] need;

    public BankersAlgorithm(int numberOfResources, int numberOfProcesses, int[] available, int[][] maximum,
            int[][] allocation) {
        this.numberOfResources = numberOfResources;
        this.numberOfProcesses = numberOfProcesses;
        this.available = available;
        this.maximum = maximum;
        this.allocation = allocation;
        this.need = new int[numberOfProcesses][numberOfResources];
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                this.need[i][j] = this.maximum[i][j] - this.allocation[i][j];
            }
        }
    }

    public boolean isSafe() {
        boolean[] finished = new boolean[numberOfProcesses];
        int[] work = Arrays.copyOf(available, numberOfResources);
        ArrayList<Integer> safeSequence = new ArrayList<>();

        for (int i = 0; i < numberOfProcesses; i++) {
            if (!finished[i] && checkNeed(i, work)) {
                for (int j = 0; j < numberOfResources; j++) {
                    work[j] += allocation[i][j];
                }
                finished[i] = true;
                safeSequence.add(i);
                i = -1;
            }
        }

        for (boolean b : finished) {
            if (!b) {
                return false;
            }
        }

        for (int process : safeSequence) {
            System.out.println("Allocated process : " + process);
        }
        return true;
    }

    private boolean checkNeed(int process, int[] work) {
        for (int i = 0; i < numberOfResources; i++) {
            if (need[process][i] > work[i]) {
                return false;
            }
        }
        return true;
    }
}
