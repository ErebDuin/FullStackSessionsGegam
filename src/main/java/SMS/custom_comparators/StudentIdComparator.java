package SMS.custom_comparators;

import SMS.Student;

import java.util.Comparator;

/**
 * Comparator for sorting students by id.
 */
public class StudentIdComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getId() - s2.getId();
    }
}
