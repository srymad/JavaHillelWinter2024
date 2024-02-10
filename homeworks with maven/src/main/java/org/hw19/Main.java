package org.hw19;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Player player = new Player();
        Player computer = new Player();

        Game game = new Game(player, computer);


        Scanner sc = new Scanner(System.in);

        System.out.print("Input count of games: ");
        int x = sc.nextInt();

        int i = 1;

        while(i <= x){
            System.out.println("You can stop the game by typing 's' or 'c' to continue");
            if(sc.next().equals("s")) break;

            System.out.println("-".repeat(20));
            System.out.printf("Game #%d\n", i);
            System.out.println("Make your choice(rock || paper || scissors)");

            System.out.print("Your choice: ");
            game.isValidChoice(sc.next());

            String computerChoice = getRandomSymbol();
            System.out.print("Computer choice: " + computerChoice);
            computer.setSymbol(computerChoice.charAt(0));

            System.out.println('\n' + "-".repeat(20));

            game.calculateWinner();
            System.out.println("-".repeat(20));
            i++;
        }

        System.out.println(game.getResults(player, computer));

    }

    public static String getRandomSymbol(){
        Random random = new Random();
        int x = random.nextInt(3);
        return switch (x) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> null;
        };

    }

}
