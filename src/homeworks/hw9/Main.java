package homeworks.hw9;

public class Main {
    public static void main(String[] args) {
        MyCollection names = new MyCollection();

        names.add("Joe");
        names.add(1, "Moe");
        names.add(1, "Nick");

        System.out.println(names.get(1));
        System.out.println(names.get(2));

        names.add(7, "John");
        names.add("Finn");
        names.add("Carol");
        names.add("Jack");

        names.delete("Joe");
        System.out.println(names.get(0));
        names.delete(0);
        System.out.println(names.get(0));
        System.out.println(names.get(15));

        names.add("Max");
        names.add("Teo");

        System.out.println(names);

        names.add(0, "Noel");

        System.out.println(names);




    }
}
