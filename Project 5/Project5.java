/* author: Tien Nguyen
 * date: December-06-2015
 * description: Coding the fizzbuzz game using the classes and objects, arrys of objects, methods, file I/O and loops.
 */
package project.pkg5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Project5 {

    //DO NOT ALTER THIS METHOD
    public static void main(String[] args) {

        //populate arrays for players and game turns from the input files
        Player[] player = readPlayers("am_fizzbuzz_players.txt");
        String[] game = readGame("am_fizzbuzz_game.txt");
        //play the game
        play(player, game);
        //print out game statistics
        statistics(player, game);
    }

    /* readPlayers - read player data from input file and return array of player objects
     * input: String fileName - name of the input file
     * return: Player[] - the array with the player data (only players at or over 21)
     */
    private static Player[] readPlayers(String fileName) {

        Scanner readPlayersScanner = null;

        // Open the file and tell user if the it couldnt find the file
        try {
            readPlayersScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + fileName);

            System.exit(1);
        }

        //read integer in first line of file to set the array size
        int size = readPlayersScanner.nextInt();
        Player[] participant = new Player[size];

        //read file, populate the array
        for (int i = 0; i < size; i++) {
            Player contestant = new Player(readPlayersScanner.next(), readPlayersScanner.nextInt());
            participant[i] = contestant;

        }
        //return the array to the invoking method (replace null with your array)
        return participant;

    }

    /* readGame - read turn data from input file and return array of game turns 
     * input: String fileName - name of the input file
     * return: String[] - the array with the turn data 
     */
    private static String[] readGame(String fileName) {

        Scanner readGameScanner = null;
        //read integer in first line of file to set the array size
        try {
            readGameScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + fileName);

            System.exit(1);
        }
        //read in game turns
        int storage = readGameScanner.nextInt();
        String[] game = new String[storage];
        for (int i = 0; i < storage; i++) {
            game[i] = readGameScanner.next();
        }
        //return game turn array (replace null with your array)
        return game;
    }

    /* play - simulate game, each player takes one turn in order, if the player is wrong, take a drink, otherwise, just take a turn
     * input: Player[] player - player array
     *        String[] game   - turn array
     * return: nothing
     */
    private static void play(Player[] player, String[] game) {

        //simulate the game
        //each player takes a turn in order
        //compare turn from file to the correct fizzbuzz answer
        //if player's guess was correct, take a turn, 
        //take a drink if the player was wrong
        for (int i = 0; i < game.length; i++) {
            if (game[i].equals(isFizzOrBuzz(i + 1))) {
                player[i % player.length].takeTurn();
            } else {
                player[i % player.length].takeDrink();
            }
        }

    }

    /* isFizzOrBuzz - check if a number is fizz (divisible by 3), buzz (divisible by 5), 
     *                fizzbuzz(divisible by both 3 and 5), or just a number
     * input: int number - the number to check
     * return: String - fizz, buzz, fizzbuzz or a number
     */
    private static String isFizzOrBuzz(int number) {
        String result = "";
        //effect the total drinks taken
        if ((number % 3 == 0) && (number % 5 == 0)) {
            result = "fizzbuzz";
        } else if ((number % 3) == 0) {
            result = "fizz";
        } else if ((number % 5) == 0) {
            result = "buzz";
        } else {
            result = Integer.toString(number);
        }

        //figure out the result based on FizzBuzz rules  
        return result;
    }

    /* statistics - print game statistics as specified
     * input: Player[] player - player array
     *        String[] game   - turn array
     * return: nothing
     */
    private static void statistics(Player[] player, String[] game) {

        System.out.println("Game Statistics:");
        System.out.println("---------------");

        //total number of turns
        System.out.println("Total turns: " + game.length);

        //declared and add $3 to dark fund of each player
        int darkFund = 0;
        darkFund = Player.getNumberOfPlayers() * 3;

        //total number of drinks taken by all players
        System.out.println("Total drinks taken: " + Player.getNumberOfTotalDrinks());
        System.out.println("");
        for (int i = 0; i < player.length; i++) {
            // --name-- (funds: --player funds after buy in--), --number of turns-- turns, --number of drinks-- drinks
            System.out.printf("Player %3d: %30s (funds: $%2d),  %2d turns,  %2d drinks \n", (i + 1), player[i].getName(), player[i].getFunds(), player[i].getTurns(), player[i].getDrinks());
        }
        System.out.println("");

        int maxiumDrink = 0;
        int miniumDrink = 0;

        //least number of drinks
        miniumDrink = player[0].getDrinks();
        // comparing each player in the array who has the least amount of drinks
        for (int i = 0; i < player.length; i++) {
            if (miniumDrink > player[i].getDrinks()) {
                miniumDrink = player[i].getDrinks();

            }

        }
        //take the money from the dark fund and give each winner $10
        System.out.printf("Winner(s): (%d drinks):\n", miniumDrink);
        for (int i = 0; i < player.length; i++) {
            if (miniumDrink == player[i].getDrinks()) {
                //- --player name-- - $10 prize (player funds: --player funds after adding the prize money --)
                System.out.printf("- %s - $10 prize (player funds: $%d) \n", player[i].getName(), player[i].getFunds() + 10);
                darkFund -= 10;
            }
        }

        System.out.println("");
        System.out.println("");

        //most number of drinksmost number of drinks
        maxiumDrink = player[0].getDrinks();

        // comparing each player in the array who has the most amount of drinks
        for (int i = 0; i < player.length; i++) {
            if (maxiumDrink < player[i].getDrinks()) {
                maxiumDrink = player[i].getDrinks();

            }

        }
        //when losing player want to buy himself out take $15 for each day from that loser and put it in the dark fund
        System.out.printf("Loser(s):   (%d drinks):\n", maxiumDrink);
        for (int i = 0; i < player.length; i++) {
            if (maxiumDrink == player[i].getDrinks()) {
                //- --player name-- - --number of days of punishment--  days of cleaning the Tower of Art (player funds: --player funds after buying out of punishment--)
                System.out.printf("- %s - 6 days of cleaning the Tower of Art (player funds: $%d) \n ", player[i].getName(), player[i].getFunds() - 15);
                darkFund += 15;
            }

        }
        System.out.println("");

        // money in dark fund after buy ins for game, prizes and punishment buyouts
        System.out.println("Dark fund: $" + darkFund);
        System.out.println("");

        //one bottle of scumble has 20 drinks. Divide the total drinks by 20 to get the number of bottles they consumed
        System.out.printf("Bottles of Scumble consumed: %.2f ", Player.getNumberOfTotalDrinks() / 20.0);

    }
}
