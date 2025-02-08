package circularlinkedlist.taskscheduler;

class TaskScheduler {
    private Task head = null;
    private Task tail = null;

    // Add task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            head.next = head;
            head.prev = head;
        } else {
            newTask.next = head;
            newTask.prev = tail;
            head.prev = newTask;
            tail.next = newTask;
            head = newTask;
        }
    }

    // Add task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            head.next = head;
            head.prev = head;
        } else {
            newTask.next = head;
            newTask.prev = tail;
            tail.next = newTask;
            head.prev = newTask;
            tail = newTask;
        }
    }

    // Add task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        newTask.prev = temp;
        temp.next.prev = newTask;
        temp.next = newTask;

        if (temp == tail) { // Update tail if added at the end
            tail = newTask;
        }
    }

    // Remove task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;

        // If the task to remove is the head
        if (temp.taskId == taskId) {
            if (head == tail) { // Single node in the list
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }

        // Traverse the list to find the task
        do {
            if (temp.taskId == taskId) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                // If the task is the tail, update the tail
                if (temp == tail) {
                    tail = temp.prev;
                }

                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNextTask(Task currentTask) {
        if (currentTask == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task: ID " + currentTask.taskId + ", Name: " + currentTask.taskName);
        currentTask = currentTask.next; // Move to the next task
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with Priority " + priority + ":");
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with Priority " + priority + ".");
        }
    }
}
