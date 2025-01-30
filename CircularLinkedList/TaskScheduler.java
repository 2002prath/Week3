package CircularLinkedList;



    class TaskScheduler {

        // Node class representing each Task
        static class TaskNode {
            int taskId;
            String taskName;
            int priority;
            String dueDate;
            TaskNode next;

            TaskNode(int taskId, String taskName, int priority, String dueDate) {
                this.taskId = taskId;
                this.taskName = taskName;
                this.priority = priority;
                this.dueDate = dueDate;
                this.next = null;
            }
        }

        private TaskNode head = null;
        private TaskNode tail = null;
        private TaskNode currentTask = null; // Pointer to the current task

        // Add a task at the end
        public void addTask(int taskId, String taskName, int priority, String dueDate) {
            TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);

            if (head == null) { // First task
                head = newTask;
                tail = newTask;
                newTask.next = head; // Circular linking
            } else {
                tail.next = newTask;
                tail = newTask;
                tail.next = head; // Maintain circular structure
            }

            if (currentTask == null) {
                currentTask = head; // Set the first task as the current task
            }

            System.out.println("✅ Task Added: " + taskName);
        }

        // Remove a task by Task ID
        public void removeTask(int taskId) {
            if (head == null) {
                System.out.println("❌ Task List is empty.");
                return;
            }

            TaskNode temp = head;
            TaskNode prev = null;

            // Search for the task
            do {
                if (temp.taskId == taskId) {
                    if (temp == head && temp == tail) { // Single node case
                        head = tail = null;
                    } else if (temp == head) { // Remove head node
                        head = head.next;
                        tail.next = head;
                    } else if (temp == tail) { // Remove tail node
                        prev.next = head;
                        tail = prev;
                    } else { // Middle node removal
                        prev.next = temp.next;
                    }
                    System.out.println("🗑️ Task Removed: " + temp.taskName);
                    return;
                }
                prev = temp;
                temp = temp.next;
            } while (temp != head);

            System.out.println("❌ Task Not Found: " + taskId);
        }

        // View the current task and move to the next one (circular)
        public void nextTask() {
            if (currentTask == null) {
                System.out.println("📌 No tasks available.");
                return;
            }
            System.out.println("📌 Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ")");
            currentTask = currentTask.next; // Move to the next task in a circular manner
        }

        // Display all tasks
        public void displayTasks() {
            if (head == null) {
                System.out.println("📜 No tasks in the list.");
                return;
            }

            TaskNode temp = head;
            System.out.println("\n🔄 Task List:");
            do {
                System.out.println("🔹 Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                temp = temp.next;
            } while (temp != head);
        }

        // Search for a task by priority
        public void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("📜 No tasks available.");
                return;
            }

            TaskNode temp = head;
            boolean found = false;
            do {
                if (temp.priority == priority) {
                    System.out.println("✅ Task Found: " + temp.taskName + " (Task ID: " + temp.taskId + ")");
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("❌ No tasks found with priority: " + priority);
            }
        }

        public static void main(String[] args) {
            TaskScheduler scheduler = new TaskScheduler();

            // Adding tasks
            scheduler.addTask(1, "Complete Assignment", 1, "2025-01-30");
            scheduler.addTask(2, "Buy Groceries", 3, "2025-02-02");
            scheduler.addTask(3, "Prepare for Meeting", 2, "2025-02-05");

            scheduler.displayTasks();

            // Move through tasks
            scheduler.nextTask();
            scheduler.nextTask();
            scheduler.nextTask(); // Loops back to first task

            // Search by priority
            scheduler.searchByPriority(2);

            // Remove a task
            scheduler.removeTask(2);
            scheduler.displayTasks();
        }
    }


