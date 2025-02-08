package Session11;

public class ExtendsKeyword {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John";
        person.age = 30;
        person.introduce();

        Student student = new Student();
        student.name = "Joffrey";
        student.age = 20;
        student.studentID = "123456";
        student.introduce();
        student.study();
    }
}
