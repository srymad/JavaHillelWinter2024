package org.hw19;

public class Game {
    private int countOfGames;
    private Player player;
    private Player computer;

    public Game(Player player, Player computer) {
        countOfGames = 0;
        this.player = player;
        this.computer = computer;
    }

    public String getResults(Player player, Player computer){
        System.out.println("\n".repeat(3));

        System.out.println("Games were played: " + countOfGames);
        System.out.println("-".repeat(20));
        System.out.printf("%d wins | %d losses", player.getWins(), player.getLosses());

        System.out.println('\n' + "-".repeat(20));
        if(player.getWins() > computer.getWins()){
            return "You won";
        }
        else if (player.getWins() < computer.getWins()) {
            return "You lost";
        }
        else return "Draw" ;

    }

    public void calculateWinner(){
        if(player.getSymbol() == 'r' && computer.getSymbol() == 's'
                || player.getSymbol() == 'p' && computer.getSymbol() == 'r'
                || player.getSymbol() == 's' && computer.getSymbol() == 'p')
        {
            System.out.println("You won");
            player.setWins(player.getWins() + 1);
            computer.setLosses(computer.getLosses() + 1);

        }else if(player.getSymbol() == computer.getSymbol()) System.out.println("Draw");
        else{
            System.out.println("You lost");
            computer.setWins(computer.getWins() + 1);
            player.setLosses(player.getLosses() + 1);
        }

        countOfGames++;

    }

    public boolean isValidChoice(String choice) throws Exception{
        if(!choice.equalsIgnoreCase("rock") && !choice.equalsIgnoreCase("paper") && !choice.equalsIgnoreCase("scissors")){
            throw new RuntimeException("Wrong choice input");
        }
        player.setSymbol(choice.charAt(0));
        return true;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public int getCountOfGames() {
        return countOfGames;
    }

    public void setCountOfGames(int countOfGames) {
        this.countOfGames = countOfGames;
    }
}
