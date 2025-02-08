package circularlinkedlist.roundrobinschedulingalgo;

public class RoundRobinMain {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 15, 2);
        scheduler.addProcess(3, 20, 3);

        // Display processes
        scheduler.displayProcesses();

        // Simulate round-robin scheduling
        int timeQuantum = 5;
        scheduler.simulateRoundRobin(timeQuantum);

        // Display remaining processes (should be empty after simulation)
        scheduler.displayProcesses();
    }
}

