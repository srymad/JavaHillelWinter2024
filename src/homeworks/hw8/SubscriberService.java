package homeworks.hw8;

public interface SubscriberService {
    void subscribersCityCallDurationExceeded(int callTraffic);
    void subscribersIntercityCalls();
    void findSubscriber(char c);
    void summaryInternetTrafficOfCity(String city);
    void subscribersWithNegativeBalance();
}
