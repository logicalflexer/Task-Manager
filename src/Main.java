import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TaskManager.createNewDatabase();
        TaskManager.createTasksTable();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add New Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewTask();
                    break;
                case "2":
                    viewAllTasks();
                    break;
                case "3":
                    updateTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    exit = true;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private static void addNewTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter status (Pending/Completed): ");
        String status = scanner.nextLine();

        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();

        Task task = new Task(title, description, status, dueDate);
        TaskManager.insertTask(task);
        System.out.println("Task added successfully.");
    }

    private static void viewAllTasks() {
        List<Task> tasks = TaskManager.getAllTasks();
        System.out.println("\n--- Task List ---");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getStatus());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("---------------------------");
        }
    }

    private static void updateTask() {
        System.out.print("Enter the ID of the task to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Task task = new Task();
        task.setId(id);

        System.out.print("Enter new title: ");
        task.setTitle(scanner.nextLine());

        System.out.print("Enter new description: ");
        task.setDescription(scanner.nextLine());

        System.out.print("Enter new status (Pending/Completed): ");
        task.setStatus(scanner.nextLine());

        System.out.print("Enter new due date (YYYY-MM-DD): ");
        task.setDueDate(scanner.nextLine());

        TaskManager.updateTask(task);
        System.out.println("Task updated successfully.");
    }

    private static void deleteTask() {
        System.out.print("Enter the ID of the task to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        TaskManager.deleteTask(id);
        System.out.println("Task deleted successfully.");
    }
}