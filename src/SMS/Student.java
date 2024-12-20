package SMS;

public class Student {
    int studentId;
    String firstName;
    String lastName;
    int studentAge;
    String studentMajor;

    Student(int id, String fName, String lName, int age, String sMajor) {
        this.studentId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.studentAge = age;
        this.studentMajor = sMajor;
    }

    public String toString() {
        //return "Student ID: " + studentId + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + studentAge;
        return String.format("Student ID: %d\nFirst Name: %s\nLast Name: %s\nAge: %d\nMajor: %s", studentId, firstName, lastName, studentAge, studentMajor);
    }
}