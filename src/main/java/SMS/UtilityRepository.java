package SMS;

import java.util.List;

/**
 * The StudentRepository interface provides methods to load and save students.
 */
public interface UtilityRepository {
    /**
     * Loads students from a data source.
     *
     * @return a list of students loaded from the data source
     */
    List<Student> loadStudentsFromFile();

    /**
     * Saves students to a data source.
     *
     * @param students the list of students to save
     */
    void saveStudentsToFile(List<Student> students);
}
