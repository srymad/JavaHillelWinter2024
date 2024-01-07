package homeworks.hw10;

public class Main {
    public static void main(String[] args) {

        StrCollection names = new StrCollection();
        StrCollection names2 = new StrCollection();

        names.add("Joe");
        names.add(1, "Moe");
        names.add(1, "Nick");

        names2.add("Joe");
        names2.add(1, "Moe");
        names2.add(1, "Nick");

        System.out.println(names.equals(names2));

        System.out.println(names.get(1));
        System.out.println(names.get(2));

        names.add(7, "John");
        names.add("Finn");
        names.add("Carol");
        names.add("Jack");

        names.delete("Joe");
        System.out.println(names.get(0));

        System.out.println(names.get(0));
        System.out.println(names.get(15));

        names.add("Max");
        names.add("Teo");

        System.out.println(names);

        names.add(0, "Noel");

        System.out.println(names);

        System.out.println("Size: " + names.size());

        names.clear();

        System.out.println(names);




    }

}
