package SMS;

import java.util.List;

/**
 * The FileStudentRepository class implements the StudentRepository interface
 * and provides methods to load and save students from/to a file.
 */
public class UtilityRepositoryFile implements UtilityRepository {
    private final String fileName;

    /**
     * Constructs a UtilityRepositoryFile with the specified file name.
     *
     * @param fileName the name of the file to load and save students
     */
    public UtilityRepositoryFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Loads students from the specified file.
     *
     * @return a list of students loaded from the file
     */
    @Override
    public List<Student> loadStudentsFromFile() {
        return Utility.loadStudentsFromFile(fileName);
    }

    /**
     * Saves students to the specified file.
     *
     * @param students the list of students to save
     */
    @Override
    public void saveStudentsToFile(List<Student> students) {
        Utility.saveStudentsToFile(students, fileName);
    }
}
