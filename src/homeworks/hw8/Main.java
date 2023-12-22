package homeworks.hw8;

public class Main {
    public static void main(String[] args) {
        Subscriber Joe = new Subscriber("White", "Joe", "Lviv", "+380563453");
        Subscriber Jack = new Subscriber("Orange", "Jack", "Kiyv", "+380848564");
        Subscriber Billy = new Subscriber("Blue", "Billy", "Odesa", "+380492561");
        Subscriber Kevin = new Subscriber("Black", "Kevin", "Dnipro", "+380058476");
        Subscriber Brad = new Subscriber("Grey", "Brad", "Lviv", "+380287841");
        Subscriber Michael = new Subscriber("Yellow", "Michael", "Mykolaiv", "+380725364",
                500 , 100, 0, 100);

        Subscriber[] clients = new Subscriber[]{Joe, Jack, Billy, Kevin, Brad, Michael};
        SubscriberServiceImpl subscriberService = new SubscriberServiceImpl(clients);

        subscriberService.subscribersCityCallDurationExceeded(50);
        subscriberService.subscribersWithNegativeBalance();
        subscriberService.findSubscriber('B');
        subscriberService.subscribersIntercityCalls();
        subscriberService.summaryInternetTrafficOfCity("Lviv");

    }
}
