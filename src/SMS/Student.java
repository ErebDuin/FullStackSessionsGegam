package SMS;


class Student {
    private static int studentCount = 0;
    private int studentId;
    private String firstName;
    private String lastName;
    private int studentAge;
    private String studentMajor;

    Student(int id, String fName, String lName, int age, String sMajor) {
        this.setStudentId(id);
        this.setStudentFirstName(fName);
        this.setStudentLastName(lName);
        this.setStudentAge(age);
        this.setStudentMajor(sMajor);
        this.setStudentCount(studentCount++);
    }


    public static void setStudentCount(int studentCount) {
        Student.studentCount = studentCount;
    }

    public static int idGenerator() {
        return (int) (Math.random() * 1000);
    }

    public void setStudentId(int id) {
        this.studentId = idGenerator();
    }

    public void setStudentFirstName (String fName) {
        this.firstName = fName;
    }

    public void setStudentLastName(String lName) {
        this.lastName = lName;
    }

    public void setStudentAge(int age) {
        if (age < 18 || age > 150) {
            System.out.println("Student age is incorrect");
        }
        else {
            this.studentAge = age;
        }
    }

    public void setStudentMajor(String sMajor) {
        if (sMajor.equals("Art") || sMajor.equals("Economics") || sMajor.equals("Math")) {
            this.studentMajor = sMajor;
        }
        else {
            System.out.println("Student major is incorrect");
        }
    }


    public static int getStudentCount() {
        return studentCount;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentFirstName() {
        return firstName;
    }

    public String getStudentLastName() {
        return lastName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    @Override
    public String toString() {
        //return "Student ID: " + studentId + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + studentAge;
        return String.format("\nStudent ID: %d\nFirst Name: %s\nLast Name: %s\nAge: %d\nMajor: %s\n", studentId, firstName, lastName, studentAge, studentMajor);
    }
}