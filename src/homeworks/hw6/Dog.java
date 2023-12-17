package homeworks.hw6;

public class Dog extends Animal{
    private static int countOfInstances = 0;
    private static int runDistance = 0;
    private static int swimDistance = 0;
    public Dog(String name, int age){
        super(name, age);
        countOfInstances++;
    }

    @Override
    public void run(int distance) {
        if(runDistance >= 500){
            System.out.println("Собака втомилась, вона більше не може бігати");
            return;
        }
        super.run(distance);
        runDistance += distance;
    }
    @Override
    public void swim(int distance) {
        if(swimDistance >= 10){
            System.out.println("Собака наплавалась та втомилась");
            return;
        }
        super.swim(distance);
        swimDistance += distance;
    }

    public static void getCountOfInstances() {
        System.out.printf("Було створено %d собак\n", countOfInstances);
    }
}
