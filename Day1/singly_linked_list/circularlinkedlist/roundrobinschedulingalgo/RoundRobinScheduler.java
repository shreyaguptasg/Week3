package circularlinkedlist.roundrobinschedulingalgo;

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    // Add a process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head; // Circular link
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head && temp == tail) { // Only one process in the list
                    head = tail = null;
                } else if (temp == head) { // Removing the head process
                    tail.next = head.next;
                    head = head.next;
                } else if (temp == tail) { // Removing the tail process
                    prev.next = head;
                    tail = prev;
                } else { // Removing a middle process
                    prev.next = temp.next;
                }
                System.out.println("Process " + processId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process current = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        System.out.println("Starting Round Robin Simulation...");
        while (head != null) {
            processCount++;
            current = head;
            do {
                if (current.burstTime > 0) {
                    int executionTime = Math.min(current.burstTime, timeQuantum);
                    current.burstTime -= executionTime;

                    // Update waiting and turnaround times
                    Process temp = head;
                    do {
                        if (temp != current && temp.burstTime > 0) {
                            temp.waitingTime += executionTime;
                        }
                        temp = temp.next;
                    } while (temp != head);

                    // If the process is completed
                    if (current.burstTime == 0) {
                        current.turnaroundTime = current.waitingTime + executionTime;
                        totalWaitingTime += current.waitingTime;
                        totalTurnaroundTime += current.turnaroundTime;
                        System.out.println("Process " + current.processId + " completed.");
                        removeProcess(current.processId);
                    } else {
                        System.out.println("Process " + current.processId + " executed for " + executionTime + " units.");
                    }
                }
                current = current.next;
            } while (current != head);
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
    }

    // Display processes in the queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime +
                    ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

