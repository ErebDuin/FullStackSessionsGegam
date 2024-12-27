package SMS;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManagementMain {

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
            System.out.println("==============================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                                               // Add student details
                    Student newStudent = new Student();

                    System.out.print("Enter first name: ");
                    String firstName = scanner.next();
                    newStudent.setStudentFirstName(firstName);

                    System.out.print("Enter last name: ");
                    String lastName = scanner.next();
                    newStudent.setStudentLastName(lastName);

                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    newStudent.setStudentAge(age);

                    System.out.print("Enter student major: ");
                    String major = scanner.next();
                    newStudent.setStudentMajor(major);

                    int studentId = Student.idGenerator();
                    newStudent.setStudentId(studentId);


                    students.add(newStudent);

                    System.out.println("\nInformation added successfully: \n" + students);
                    System.out.println();
                    System.out.println("Number of students:" + Student.getStudentCount());
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
                            System.out.printf("| %-3d %-15s %-15s %-3d %15s |%n", s.getStudentId(), s.getStudentFirstName(), s.getStudentLastName(), s.getStudentAge(), s.getStudentMajor());
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
                        if (students.get(i).getStudentId() == studentIdToDelete) {
                            students.remove(i);
                            found = true;
                            System.out.println("\nStudent details successfully deleted!\n");
                            System.out.println("Number of students:" + Student.getStudentCount());
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
                        if (s.getStudentId() == idToEdit){
                            System.out.print("Enter new first name: ");
                            s.setStudentFirstName(scanner.next());
                            System.out.print("Enter new last name: ");
                            s.setStudentLastName(scanner.next());
                            System.out.print("Enter new age: ");
                            s.setStudentAge(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Enter new Major: ");
                            s.setStudentMajor(scanner.next());

                            System.out.println("Student details updated successfully!");
                            idFound = true;
                            break;
                        }
                    }
                    if (!idFound){
                        System.out.println("Student ID not found.");
                    }
                    break;
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