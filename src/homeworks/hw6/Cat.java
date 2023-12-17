package homeworks.hw6;

public class Cat extends Animal{
    private static int countOfInstances = 0;
    private static int runDistance = 0;
    public Cat(String name, int age){
        super(name, age);
        countOfInstances++;
    }

    @Override
    public void run(int distance) {
        if(runDistance >= 200){
            System.out.println("Кіт втомився, він більше не може бігати");
            return;
        }
        super.run(distance);
        runDistance += distance;
    }
    @Override
    public void swim(int distance) {
        System.out.println("Кіт не вміє плавати");
    }

    public static void getCountOfInstances() {
        System.out.printf("Було створено %d котів\n", countOfInstances);
    }
}
