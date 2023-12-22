package homeworks.hw8;

import java.text.DecimalFormat;
import java.util.Random;

public class Subscriber {
    Random random = new Random();
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private String phoneNumber;
    private int contractNumber;
    private double balance;
    private double cityCallDuration;
    private double intercityCallDuration;
    private double internetTraffic;
    private static int counter = 0;
    DecimalFormat dFormat = new DecimalFormat("#.##");

    public Subscriber(String lastName, String firstName, String city, String phoneNumber) {
        id = 1000 + ++counter;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        contractNumber = random.nextInt(10000, 100000);
        balance = random.nextDouble(-100, 101);
        cityCallDuration = random.nextDouble(0, 61);
        intercityCallDuration = random.nextDouble(0, 31);
        internetTraffic = random.nextDouble(10, 1000);
    }

    public Subscriber(String lastName, String firstName, String city, String phoneNumber, double balance, double cityCallDuration, double intercityCallDuration, double internetTraffic) {
        id = 1000 + ++counter;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        contractNumber = random.nextInt(10000, 100000);
        this.balance = balance;
        this.cityCallDuration = cityCallDuration;
        this.intercityCallDuration = intercityCallDuration;
        this.internetTraffic = internetTraffic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCityCallDuration() {
        return cityCallDuration;
    }

    public void setCityCallDuration(double cityCallDuration) {
        this.cityCallDuration = cityCallDuration;
    }

    public double getIntercityCallDuration() {
        return intercityCallDuration;
    }

    public void setIntercityCallDuration(double intercityCallDuration) {
        this.intercityCallDuration = intercityCallDuration;
    }

    public double getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(double internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nName: " + lastName + " " + firstName +
                "\nPhone number: " + phoneNumber +
                "\nContract number: " + contractNumber +
                "\nBalance: " + dFormat.format(balance) + " UAH" +
                "\nCity call duration: " + dFormat.format(cityCallDuration) + " min" +
                "\nIntercity call duration: " + dFormat.format(intercityCallDuration) + " min" +
                "\nInternet traffic: " + dFormat.format(internetTraffic) + " GB";
    }
}
