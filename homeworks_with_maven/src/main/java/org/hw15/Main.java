package org.hw15;


public class Main {
    public static void main(String[] args) {
        String s = "";
        for (String n: args) s += n;

        char[] c = s.toCharArray();

        if(isNumeric(c) == null) System.out.println("Invalid input\nEnter only digits");
        else{
            print(isNumeric(c));
        }
    }

    public static int[] isNumeric(char[] c) {
        if (c == null) {
            return null;
        }
        int[] array = new int[c.length];

        try {
            for (int i = 0; i < array.length; i++) {

                array[i] = Integer.parseInt(String.valueOf(c[i]));

            }
        } catch (NumberFormatException ex) {

            return null;
        }

        return array;
    }

    public static void print(int[] arr){
        for (int i = 0; i < 4; i++) {
            for (int x:arr) {
                switch (x) {
                    case 0 -> System.out.print(zero[i]);
                    case 1 -> System.out.print(one[i]);
                    case 2 -> System.out.print(two[i]);
                    case 3 -> System.out.print(three[i]);
                    case 4 -> System.out.print(four[i]);
                    case 5 -> System.out.print(five[i]);
                    case 6 -> System.out.print(six[i]);
                    case 7 -> System.out.print(seven[i]);
                    case 8 -> System.out.print(eight[i]);
                    case 9 -> System.out.print(nine[i]);
                }
            }
            System.out.println();
        }


    }

    public static String[] one = {
            " _ ",
            "/ |",
            "| |",
            "|_|"
    };
    public static String[] two = {
            " ___ ",
            "|_  )",
            " / / ",
            "/___|"
    };
    public static String[] three ={
            " ____",
            "|__ /",
            " |_ \\",
            "|___/"
    };
    public static String[] four ={
            " _ _  ",
            "| | | ",
            "|_  _|",
            "  |_| "
    };
    public static String[] five = {
            " ___ ",
            "| __|",
            "|__ \\",
            "|___/"
    };
    public static String[] six = {
            "  __ ",
            " / / ",
            "/ _ \\",
            "\\___/"
    };
    public static String[] seven = {
            " ____ ",
            "|__  |",
            "  / / ",
            " /_/  "
    };
    public static String[] eight = {
            " ___ ",
            "( _ )",
            "/ _ \\",
            "\\___/"
    };
    public static String[] nine = {
            " ___ ",
            "/ _ \\",
            "\\_, /",
            " /_/ "
    };

    public static String[] zero = {
            "  __  ",
            " /  \\ ",
            "| () |",
            " \\__/ "
    };
}