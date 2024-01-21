package homeworks.hw12;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(new FileData("file.txt", 300, "/path/to/file"));
        fileNavigator.add(new FileData("firstApp.java", 100, "/path/to/file"));
        fileNavigator.add(new FileData("passwords.txt", 200, "/private/secret"));
        fileNavigator.add(new FileData("phones.txt", 400, "/phones"));


        System.out.println(fileNavigator);
        System.out.println();

        System.out.println(fileNavigator.find("/path/to/file"));
        System.out.println();

        System.out.println(fileNavigator.filterBySize(210));
        System.out.println();

        System.out.println(fileNavigator.sortBySize());
        System.out.println();

        fileNavigator.remove("/path/to/file");
        System.out.println(fileNavigator);

    }


}
