package SMS;

import java.util.List;

/**
 * The StudentService class provides methods to manage students, including adding, deleting, and saving students.
 */
public class StudentMaintenance {
    private final UtilityRepository utilityRepository;
    private final List<Student> students;

    /**
     * Constructs a StudentService with the specified StudentRepository.
     *
     * @param utilityRepository the StudentRepository to manage student data
     */
    public StudentMaintenance(UtilityRepository utilityRepository) {
        this.utilityRepository = utilityRepository;
        this.students = utilityRepository.loadStudentsFromFile();
    }

    /**
     * Gets the list of students.
     *
     * @return the list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the list.
     *
     * @param student the student to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to delete
     */
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    /**
     * Saves the list of students to the repository.
     */
    public void saveStudents() {
        utilityRepository.saveStudentsToFile(students);
    }
}