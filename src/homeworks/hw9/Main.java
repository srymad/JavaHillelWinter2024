package homeworks.hw9;

public class Main {
    public static void main(String[] args) {
        MyCollection names = new MyCollection();

        names.add("Joe");
        names.add(1, "Moe");

        System.out.println(names.get(1));
        System.out.println(names.get(3));

        names.add(2, "John");
        names.add("Finn");
        names.add("Carol");
        names.add("Jack");

        names.delete("Joe");
        System.out.println(names.get(0));
        names.delete(0);
        System.out.println(names.get(0));
        System.out.println(names.get(15));

        System.out.println(names);





    }
}
