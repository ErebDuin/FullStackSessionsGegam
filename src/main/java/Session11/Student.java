package Session11;

public class Student extends Person {
    String studentID;

    public void study() {
        System.out.println("I am studying...");
    }

    @Override
    public void introduce() {
        System.out.println("Hi there, my name is " + super.name + " and I am " + super.age + " years old.");
    }
}
