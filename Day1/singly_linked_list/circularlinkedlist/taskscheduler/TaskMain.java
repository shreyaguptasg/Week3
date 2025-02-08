package circularlinkedlist.taskscheduler;

public class TaskMain {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtBeginning(1, "Task 1", 1, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task 2", 2, "2025-02-02");
        scheduler.addTaskAtEnd(3, "Task 3", 1, "2025-02-03");
        scheduler.addTaskAtPosition(2, 4, "Task 4", 3, "2025-02-04");

        // Display tasks
        scheduler.displayAllTasks();

        // Remove a task
        scheduler.removeTaskById(2);

        // Search tasks by priority
        scheduler.searchTaskByPriority(1);

        // View tasks circularly
        scheduler.displayAllTasks();
    }
}

