package Session12;

abstract class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

interface Pat {
    void play();
}

class Cat extends Animal implements Pat {
    @Override
    public void play() {
        System.out.println("Cat is playing with the mouse...");
    }
}

public class InterfaceAndAbstract {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.play();
    }
}
