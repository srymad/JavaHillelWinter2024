package homeworks.hw6;

public class Animal {
    private String name;
    private int age;
    private static int countOfInstances;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        countOfInstances++;
    }

    public void run(int distance){
        System.out.printf("%s пробіг %d м\n", name, distance);
    }

    public void swim(int distance){
        System.out.printf("%s проплив %d м\n", name, distance);
    }

    public static void getCountOfInstances() {
        System.out.printf("Було створено %d тварин\n", countOfInstances);
    }
}
