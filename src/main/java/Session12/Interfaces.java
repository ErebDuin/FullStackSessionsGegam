package Session12;

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
    }
}

class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Plane is flying...");
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        bird.fly();

        Flyable plane = new Plane();
        plane.fly();
    }
}
