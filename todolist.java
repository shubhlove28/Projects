import java.util.*;

public class todolist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Remove Task\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    break;
                case 2:
                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++)
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    break;
                case 3:
                    System.out.print("Enter task number to remove: ");
                    int index = sc.nextInt();
                    if (index > 0 && index <= tasks.size())
                        tasks.remove(index - 1);
                    else
                        System.out.println("Invalid index.");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
