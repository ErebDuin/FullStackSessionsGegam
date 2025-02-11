package SMS;

import SMS.menu.MainMenu;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class is the entry point for the Student Management System application.
 * It initializes the necessary components and displays the main menu.
 */
public class Main {
    /**
     * The main method initializes the StudentRepository, StudentService, and Scanner,
     * then creates and displays the MainMenu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        UtilityRepository utilityRepository = new UtilityRepositoryFile("/Users/gegam/IdeaProjects/FullStackSessionsGegam/src/main/java/SMS/students.csv");
        StudentMaintenance studentMaintenance = new StudentMaintenance(utilityRepository);

        StudentHttpServer server = null;
        try {
            server = new StudentHttpServer(studentMaintenance);
            server.start();
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(studentMaintenance, scanner, server);
        mainMenu.displayMenu();
    }
}
