import java.util.*;

public class App {
    private static final Scanner input = new Scanner(System.in);
    private static final RecordDAO db = new RecordDAO();

    public static void main(String[] args) throws Exception {
        while (true) {
            showMenu();
            int option = getNumber("Choose: ");

            switch (option) {
                case 1 -> createRecord();
                case 2 -> showRecords();
                case 3 -> editRecord();
                case 4 -> removeRecord();
                case 5 -> quitApp();
                default -> System.out.println(" Invalid choice, try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Student Database ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    private static void createRecord() {
        System.out.print("Enter name: ");
        String fullName = input.nextLine();

        int years = getNumber("Enter age: ");

        System.out.print("Enter email: ");
        String mail = input.nextLine();

        Record rec = new Record(0, fullName, years, mail);
        db.addRecord(rec);

        System.out.println("✅ Student added!");
    }

    private static void showRecords() {
        System.out.println("📋 Student List:");
        for (Record r : db.getAllRecords()) {  
            System.out.println(r);
        }
    }

    private static void editRecord() {
        int code = getNumber("Enter student ID to update: ");

        System.out.print("Enter new name: ");
        String fullName = input.nextLine();

        int years = getNumber("Enter new age: ");

        System.out.print("Enter new email: ");
        String mail = input.nextLine();

        Record rec = new Record(code, fullName, years, mail);
        db.updateRecord(rec);

        System.out.println("✅ Student updated!");
    }

    private static void removeRecord() {
        int code = getNumber("Enter student ID to delete: ");
        db.deleteRecord(code);
        System.out.println("🗑️ Student deleted!");
    }

    private static void quitApp() {
        System.out.println("👋 Goodbye!");
        System.exit(0);
    }

    private static int getNumber(String text) {
        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
