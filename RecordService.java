
package recordservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



 class Recordservice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecordService recordService = new RecordService();
        boolean running = true;

        while (running) {
            System.out.println("1. Add Record");
            System.out.println("2. Update Record");
            System.out.println("3. Delete Record");
            System.out.println("4. Search Record");
            System.out.println("5. Display All Records");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    recordService.addRecord(new Record(name, number, description));
                    break;
                case 2:
                    System.out.print("Enter index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new number: ");
                    String newNumber = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    recordService.updateRecord(updateIndex, new Record(newName, newNumber, newDescription));
                    break;
                case 3:
                    System.out.print("Enter index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    recordService.deleteRecord(deleteIndex);
                    break;
                case 4:
                    System.out.print("Enter search criteria (name or number): ");
                    String criteria = scanner.nextLine();
                    List<Record> foundRecords = recordService.searchRecords(criteria);
                    foundRecords.forEach(System.out::println);
                    break;
                case 5:
                    List<Record> allRecords = recordService.getAllRecords();
                    allRecords.forEach(System.out::println);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}