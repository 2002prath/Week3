package CircularLinkedList;

import java.util.LinkedList;
import java.util.Queue;

class RoundRobinScheduler {

    // Process Node Class
    static class Process {
        int processId;
        int burstTime;
        int remainingTime;
        int waitingTime;
        int turnaroundTime;
        Process next;

        Process(int processId, int burstTime) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime; // Initially, remaining time = burst time
            this.waitingTime = 0;
            this.turnaroundTime = 0;
            this.next = null;
        }
    }

    private Process head = null;
    private Process tail = null;
    private int totalProcesses = 0;

    // Add a process to the end of the circular list
    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);

        if (head == null) { // First process
            head = newProcess;
            tail = newProcess;
            newProcess.next = head; // Circular linking
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular nature
        }

        totalProcesses++;
        System.out.println("✅ Process Added: P" + processId + " (Burst Time: " + burstTime + ")");
    }

    // Simulate Round Robin scheduling
    public void executeProcesses(int timeQuantum) {
        if (head == null) {
            System.out.println("⚠️ No processes available.");
            return;
        }

        int timeElapsed = 0;
        Process current = head;
        Queue<Process> processQueue = new LinkedList<>();

        // Store original order of processes
        Process temp = head;
        do {
            processQueue.add(temp);
            temp = temp.next;
        } while (temp != head);

        System.out.println("\n🔄 Starting Round Robin Execution (Time Quantum: " + timeQuantum + ")...");

        while (!processQueue.isEmpty()) {
            Process executingProcess = processQueue.poll(); // Get the process from the queue

            if (executingProcess.remainingTime > 0) {
                int executionTime = Math.min(executingProcess.remainingTime, timeQuantum);
                timeElapsed += executionTime;
                executingProcess.remainingTime -= executionTime;

                System.out.println("⏳ Executing Process P" + executingProcess.processId +
                        " for " + executionTime + " units (Remaining: " + executingProcess.remainingTime + ")");

                if (executingProcess.remainingTime > 0) {
                    // Process not completed, put it back in queue
                    processQueue.add(executingProcess);
                } else {
                    // Process completed
                    executingProcess.turnaroundTime = timeElapsed;
                    executingProcess.waitingTime = executingProcess.turnaroundTime - executingProcess.burstTime;
                    System.out.println("✅ Process P" + executingProcess.processId + " Completed (TAT: " +
                            executingProcess.turnaroundTime + ", WT: " + executingProcess.waitingTime + ")");
                    removeProcess(executingProcess.processId);
                }
            }
        }

        calculateAverageTimes();
    }

    // Remove a process after execution
    private void removeProcess(int processId) {
        if (head == null) {
            return;
        }

        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head && temp == tail) { // Only one process case
                    head = tail = null;
                } else if (temp == head) { // Removing head
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) { // Removing tail
                    prev.next = head;
                    tail = prev;
                } else { // Removing middle process
                    prev.next = temp.next;
                }

                totalProcesses--;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display all processes in the queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("📜 No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("\n🔄 Process Queue:");
        do {
            System.out.println("🔹 Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Calculate and display average waiting time and turnaround time
    private void calculateAverageTimes() {
        if (totalProcesses == 0) {
            System.out.println("⚠️ No processes left to calculate averages.");
            return;
        }

        int totalWT = 0, totalTAT = 0;
        Process temp = head;
        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\n📊 Average Turnaround Time: " + (double) totalTAT / totalProcesses);
        System.out.println("📊 Average Waiting Time: " + (double) totalWT / totalProcesses);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        scheduler.addProcess(4, 6);

        scheduler.displayProcesses();

        // Execute processes with a time quantum of 4
        scheduler.executeProcesses(4);
    }
}

