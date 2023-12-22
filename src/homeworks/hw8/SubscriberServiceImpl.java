package homeworks.hw8;

public class SubscriberServiceImpl implements SubscriberService{

    Subscriber[] clients;
    public SubscriberServiceImpl(Subscriber[] clients){
        this.clients = clients;
    }
    @Override
    public void subscribersCityCallDurationExceeded(int callTraffic) {
        System.out.println("Subscribers with exceeded city call traffic:");
        for (Subscriber element: clients) {
            if(element.getCityCallDuration() > callTraffic){
                System.out.println(element);
                System.out.println("-".repeat(40));
            }

        }
        System.out.println("-".repeat(40));
    }

    @Override
    public void subscribersIntercityCalls() {
        System.out.println("Subscribers who used intercity traffic:");
        for (Subscriber element: clients) {
            if(element.getIntercityCallDuration() > 0){
                System.out.println(element);
                System.out.println("-".repeat(40));
            }
        }
        System.out.println("-".repeat(40));
    }

    @Override
    public void findSubscriber(char c) {
        System.out.println("Subscribers with the first letter " + c + " in surname:");
        for (Subscriber element: clients) {
            if(element.getLastName().charAt(0) == c){
                System.out.printf("Name: %s %s\nPhone number: %s\nBalance: %.2f\n",
                        element.getLastName(), element.getFirstName(), element.getPhoneNumber(), element.getBalance());
                System.out.println("-".repeat(40));
            }
        }
        System.out.println("-".repeat(40));
    }

    @Override
    public void summaryInternetTrafficOfCity(String city) {
        double summaryInternetTraffic = 0;
        for (Subscriber element: clients) {
            if(element.getCity().equalsIgnoreCase(city)){
                summaryInternetTraffic += element.getInternetTraffic();
            }
        }
        System.out.printf("Summary internet traffic usage in %s: %.2f GB\n", city, summaryInternetTraffic);
        System.out.println("-".repeat(40));
    }

    @Override
    public void subscribersWithNegativeBalance() {
        int countWithNegBalance = 0;
        for (Subscriber element: clients) {
            if(element.getBalance() < 0){
                countWithNegBalance++;
            }
        }
        System.out.println("Count of subscribers with negative balance: " + countWithNegBalance);
        System.out.println("-".repeat(40));
    }
}
