package SMS;

import SMS.custom_exceptions.IllegalGpaException;


public class GraduationProcess {
    private static StudentMaintenance studentMaintenance;

    public static GraduateStudent graduateStudentByIdAndGpa(int id, double gpa, StudentMaintenance studentToGraduate) {
        studentMaintenance = studentToGraduate;
        GraduateStudent graduatedStudent = null;

        try {
            Student student = studentMaintenance.getStudents()
                    .stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (student != null && !(student instanceof GraduateStudent)) {
                GraduateStudent graduateStudent = new GraduateStudent(
                        student.getId(),
                        student.getEMail(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge(),
                        student.getMajor());

                try {
                    graduateStudent.setGPA(gpa);
                } catch (IllegalGpaException e) {
                    System.out.println("Invalid GPA: " + e.getMessage());
                }

                studentMaintenance.deleteStudent(id);
                studentMaintenance.addStudent(graduateStudent);
                studentMaintenance.saveStudents();
                graduatedStudent = graduateStudent;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return graduatedStudent;
    }
}
