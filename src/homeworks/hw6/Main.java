package homeworks.hw6;

public class Main {

    public static void main(String[] args) {
        Cat kit = new Cat("Kit", 5);
        Dog bobik = new Dog("Bobik", 3);
        Animal animal = new Animal("asdfsa", 4);

        kit.swim(10);
        kit.run(200);
        kit.run(1);

        System.out.println();

        bobik.swim(10);
        bobik.swim(1);
        bobik.run(500);
        bobik.run(1);

        System.out.println();
        Cat.getCountOfInstances();
        Dog.getCountOfInstances();
        Animal.getCountOfInstances();

    }
}
