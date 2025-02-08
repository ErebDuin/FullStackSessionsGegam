package PilotSMS;

import java.util.Comparator;
import java.util.List;

public class StudentSorter {

    public static void sortById(List<Student> students) {
        students.sort(Comparator.comparingInt(Student::getStudentId));
    }

    public static void sortByFirstName(List<Student> students) {
        students.sort(Comparator.comparing(Student::getStudentFirstName));
    }

    public static void sortByLastName(List<Student> students) {
        students.sort(Comparator.comparing(Student::getStudentLastName));
    }

    public static void sortByAge(List<Student> students) {
        students.sort(Comparator.comparingInt(Student::getStudentAge));
    }

    public static void sortByMajor(List<Student> students) {
        students.sort(Comparator.comparing(Student::getStudentMajor));
    }

    public static void sortByGpa(List<Student> students) {
        students.sort(Comparator.comparingDouble(s -> {
            if (s instanceof GraduateStudent) {
                return ((GraduateStudent) s).getStudentGpa();
            }
            return 0.0;
        }));
    }

    public static void sortByType(List<Student> students) {
            students.sort(Comparator.comparing(s -> s instanceof GraduateStudent ? "Graduate" : "Undergraduate"));
    }
}