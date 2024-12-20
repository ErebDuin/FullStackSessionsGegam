package SMS;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManagement {

    public static int idGenerator() {
        return (int) (Math.random() * 1000);
    }


    public static String getFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String acquiredFirstName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
        while (true) {                                                               // Ask first name until it is between 3 and 15 characters
            if (acquiredFirstName.length() < 3 || acquiredFirstName.length() > 15) {
                System.out.println("\nFirst name should be between 3 and 15 characters\n");
                System.out.print("Enter first name: ");
                acquiredFirstName = scanner.next().trim();
            } else {
                break;
            }
        }
        return acquiredFirstName;
    }


    public static String getLastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String acquiredLastName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
        while (true) {                                                                     // Ask last name until it is between 3 and 15 characters
            if (acquiredLastName.length() < 3 || acquiredLastName.length() > 15) {
                System.out.println("\nLast name should be between 3 and 15 characters\n");
                System.out.print("Enter last name: ");
                acquiredLastName = scanner.next().trim();
            } else {
                break;
            }
        }
        return acquiredLastName;
    }


    public static int getAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student age: ");
        return scanner.nextInt();
    }


    public static String getMajor(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student major: ");
        return scanner.next();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n======== Student Menu ========");
            System.out.println("1. Add Student Details");
            System.out.println("2. View Student Details");
            System.out.println("3. Delete Student Details");
            System.out.println("4. Edit Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                                               // Add student details
                    String firstName = getFirstName();
                    String lastName = getLastName();
                    int studentAge = getAge();
                    String studentMajor = getMajor();
                    int studentId = idGenerator();

                    Student newStudentCreated = new Student(studentId, firstName, lastName, studentAge, studentMajor);

                    students.add(newStudentCreated);

                    System.out.println("\nInformation added successfully: \n" + students.toString());
                    System.out.println();
                    break;
                case 2:                                                      // View student details
                    if (students.isEmpty()) {
                        System.out.println("\nNo student details available.\n");
                    } else {
                        String header = String.format("%-21s %15s %21s", "=====================", "Student Details", "=====================");
                        System.out.println(header);
                        String title = String.format("| %-3s %-15s %-15s %-3s %15s |", "ID", "First Name", "Last Name", "Age", "Major");
                        System.out.println(title);
                        String border = "|";
                        String divider = "-".repeat(header.length() - 2);
                        System.out.println(border + divider + border);
                        for (Student s : students) {
                            System.out.printf("| %-3d %-15s %-15s %-3d %15s |%n", s.studentId, s.firstName, s.lastName, s.studentAge, s.studentMajor);
                        }
                        for (int i = 0; i < header.length(); i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                    }
                    break;
                case 3:                                                       // Reset student details
                    System.out.print("\nEnter student id to delete student details: ");
                    int studentIdToDelete = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).studentId == studentIdToDelete) {
                            students.remove(i);
                            found = true;
                            System.out.println("\nStudent details successfully deleted!\n");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nStudent ID not found.\n");
                    }
                    break;
                case 4:                                                       // Edit student details
                    // define the edit student details
                    // search for the student id
                    // found/not found
                    // set new vallues

                    System.out.print("Enter student ID to edit: ");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();

                    boolean idFound = false;
                    for (Student s : students){
                        if (s.studentId == idToEdit){
                            System.out.println("Enter new first name: ");
                            s.firstName = scanner.next();
                            System.out.println("Enter new last name: ");
                            s.lastName = scanner.next();
                            System.out.println("Enter new age: ");
                            s.studentAge = scanner.nextInt();
                            scanner.nextLine();
                            s.studentMajor = scanner.next();
                            System.out.println("Enter new Major: ");

                            System.out.println("Student details updated successfully!");
                            idFound = true;
                            break;
                        }
                    }
                    if (!idFound){
                        System.out.println("Student ID not found.");
                    }

                case 5:                                                       // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:                                                      // Invalid option
                    System.out.print("\nNot supported option,\nPlease try again!\n\n");
            }
        }
    }
}