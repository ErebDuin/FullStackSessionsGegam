package PilotSMS;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static PilotSMS.SmsJSON.loadFromJSON;
import static PilotSMS.SmsJSON.saveToJSON;


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
            System.out.println("5. Save to JSON");
            System.out.println("6. Load from JSON");
            System.out.println("7. Exit");
            System.out.println("==============================");
            System.out.print("Enter your Choice: ");
            int menuChoice = 0;

            try {
                menuChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
                continue;
            }

            switch (menuChoice) {
                case 1:                                               // Add student details
                    System.out.println("\n======== Student Menu ========");
                    System.out.println("1. Add Graduate Student");
                    System.out.println("2. Add Undergraduate Student");
                    System.out.println("==============================");
                    System.out.print("Choose student type: ");
                    int studentType = scanner.nextInt();
                    scanner.nextLine();

                    Student newStudent;

                    System.out.print("Enter first name: ");
                    String firstName = scanner.next();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.next();

                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();

                    System.out.print("Enter student major: ");
                    String major = scanner.next();

                    int studentId = Student.idGenerator();

                    if (studentType == 1) {
                        newStudent = new GraduateStudent();
                        System.out.print("Enter student GPA: ");
                        double gpa = scanner.nextDouble();
                        ((GraduateStudent) newStudent).setStudentGpa(gpa);
                    } else if (studentType == 2) {
                        newStudent = new UndergraduateStudent();
                    }
                    else {
                        System.out.println("Invalid student type.");
                        break;
                    }

                    newStudent.setStudentFirstName(firstName);
                    newStudent.setStudentLastName(lastName);
                    newStudent.setStudentAge(age);
                    newStudent.setStudentMajor(major);
                    newStudent.setStudentId(studentId);

                    students.add(newStudent);
                    // print the student details just added

                    System.out.println("\nInformation added successfully: \n");
                    newStudent.displayStudentData();
                    System.out.println();
                    System.out.println("Number of students:" + Student.getStudentCount());
                    break;
                case 2:                                                      // View student details
//                    students = loadFromJSON();
                    System.out.println("\n======== Student Menu ========");
                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by First Name");
                    System.out.println("3. Sort by Last Name");
                    System.out.println("4. Sort by Age");
                    System.out.println("5. Sort by Major");
                    System.out.println("6. Sort by GPA");
                    System.out.println("7. Sort by Student Type");
                    System.out.println("==============================");
                    System.out.print("Choose how to sort: ");
                    int sortBy = scanner.nextInt();
                    scanner.nextLine();

                    if (students.isEmpty()) {
                        System.out.println("\nNo student details available.\n");
                    } else {
                        switch (sortBy) {
                            case 1:
                                StudentSorter.sortById(students);
                                break;
                            case 2:
                                StudentSorter.sortByFirstName(students);
                                break;
                            case 3:
                                StudentSorter.sortByLastName(students);
                                break;
                            case 4:
                                StudentSorter.sortByAge(students);
                                break;
                            case 5:
                                StudentSorter.sortByMajor(students);
                                break;
                            case 6:
                                StudentSorter.sortByGpa(students);
                                break;
                            case 7:
                                StudentSorter.sortByType(students);
                                break;
                            default:
                                System.out.println("Invalid sort type.");
                                break;
                        }
                        String header = String.format("%-33s %15s %32s", "=================================", "Student Details", "================================");
                        System.out.println(header);
                        String title = String.format("| %-3s %-15s %-15s %-3s %-15s %4s %17s |", "ID", "First Name", "Last Name", "Age", "Major", "GPA", "Student Type");
                        System.out.println(title);
                        String border = "|";
                        String divider = "-".repeat(header.length() - 2);
                        System.out.println(border + divider + border);
                        for (Student s : students) {
                            System.out.printf("| %-3d %-15s %-15s %-3d %-15s %4.1f %17s |%n",
                                                                                s.getStudentId(),
                                                                                s.getStudentFirstName(),
                                                                                s.getStudentLastName(),
                                                                                s.getStudentAge(),
                                                                                s.getStudentMajor(),
                                                                                s instanceof GraduateStudent ? ((GraduateStudent)s).getStudentGpa() : null,
                                                                                s instanceof GraduateStudent ? "Graduate" : "Undergraduate");
                        }
                        for (int i = 0; i < header.length(); i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                    }
                    break;
                case 3:                                                       // Reset student details
                    System.out.print("\nEnter student id to delete: ");
                    int studentIdToDelete = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getStudentId() == studentIdToDelete) {
                            students.remove(i);
                            found = true;
                            System.out.println("\nStudent successfully deleted!\n");
                            System.out.println("Number of students:" + Student.getStudentCount());
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nStudent ID not found.\n");
                    }
                    break;
                case 4:                                                       // Edit student details
                    System.out.print("Enter student ID to edit: ");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();

                    boolean idFound = false;
                    for (Student s : students){
                        if (s.getStudentId() == idToEdit) {
                            System.out.print("Enter new first name: ");
                            s.setStudentFirstName(scanner.next());
                            System.out.print("Enter new last name: ");
                            s.setStudentLastName(scanner.next());
                            System.out.print("Enter new age: ");
                            s.setStudentAge(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Enter new Major: ");
                            s.setStudentMajor(scanner.next());

                            if (s instanceof GraduateStudent) {
                                System.out.print("Enter new GPA: ");
                                ((GraduateStudent) s).setStudentGpa(scanner.nextDouble());
                            }

                            System.out.println("Student details updated successfully!");
                            idFound = true;
                            break;
                        }
                    }
                    if (!idFound){
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 5:                                                       // Save to JSON
                    saveToJSON(students);
                    System.out.println("\nStudent details saved to JSON successfully!\n");
                    break;
                case 6:                                                       // Load from JSON
                    loadFromJSON();
                    System.out.println(loadFromJSON());
                    System.out.println("\nStudent details loaded from JSON successfully!\n");
                    break;
                case 7:                                                       // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:                                                      // Invalid option
                    System.out.print("\nNot supported option,\nPlease try again!\n\n");
            }
        }
    }
}