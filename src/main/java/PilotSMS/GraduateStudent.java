package PilotSMS;

import static PilotSMS.GpaValidationException.validateGpa;

public class GraduateStudent extends Student {
    private double studentGpa;

    public void setStudentGpa(double gpa) {
        try {
            validateGpa(gpa);
            this.studentGpa = gpa;
        } catch (InvalidGpaException e) {
            System.out.println("Invalid GPA: " + e.getMessage());
            System.exit(0);
        }
    }

    public double getStudentGpa() {
        return studentGpa;
    }

    public void displayStudentData() {
        super.displayStudentData();
        System.out.println("GPA: " + getStudentGpa());
    }
}
