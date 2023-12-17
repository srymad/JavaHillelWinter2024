package homeworks.hw5;

public class Car {
    private String model;
    private int maxSpeed;

    public Car(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void start(){
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("\nCar is ready to start");
    }

    private void startElectricity(){
        System.out.println("--Starting electricity--");
    }

    private void startCommand(){
        System.out.println("--Starting command--");
    }

    private void startFuelSystem(){
        System.out.println("--Starting fuel system--");
    }
}
