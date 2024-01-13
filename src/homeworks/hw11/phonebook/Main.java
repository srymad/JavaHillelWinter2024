package homeworks.hw11.phonebook;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory ph = new PhoneDirectory();
        ph.add(new Record("Joe", "08458453"));
        ph.add(new Record("Moe", "03440454"));
        ph.add(new Record("Connor", "01902941"));
        ph.add(new Record("Connor", "05455642"));
        ph.add(new Record("Mike", "07234353"));
        ph.add(new Record("Moe", "06945421"));

        System.out.println(ph);

        System.out.println(ph.find("Connor"));

        System.out.println(ph.findAll("Moe"));
    }
}
