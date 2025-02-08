package Session11;

public class GraduateStudentSample {

    static void describeStudent(Student student) {

    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Joffrey";
        student.age = 20;
        student.studentID = "654321";

        GraduateStudent graduateStudent = new GraduateStudent();
        graduateStudent.name = "Jon";
        graduateStudent.age = 25;
        graduateStudent.studentID = "987654";
        graduateStudent.researchTopic = "Machine Learning";

        student.introduce();
        graduateStudent.introduce();
    }
}
