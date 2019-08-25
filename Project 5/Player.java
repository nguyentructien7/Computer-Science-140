/*/* author: Tien Nguyen
 * date: December-06-2015
 * description: Coding the fizzbuzz game using the classes and objects, arrys of objects, methods, file I/O and loops.
 */
 
package project.pkg5;


//DO NOT ALTER THIS CLASS!!
public class Player {
    //instace variables
    private int id;
    private String name;
    private int funds;
    
    private int turns;
    private int drinks;
    
    //class variables
    private static int numberOfPlayers = 0;
    private static int totalDrinks = 0;
    
    /* Player - standard constructor
     * input: none
     */
    public Player() {
        this.id = 0;
        this.name = "";
        this.funds = 0;
        this.turns = 0;
        this.drinks = 0;
    }
    
     /* Player - constructor
      * input: String name - player name 
      *        int funds   - player funds
      */
    public Player( String name, int funds ) {
        this();
        this.name = name;       
        this.funds = funds - 3;

        numberOfPlayers++;
        this.id = numberOfPlayers;            
    }
    
    /* takeTurn - increment turns instance variable on every player turn
     * input: none
     * return: nothing
     */
    public void takeTurn() {
        this.turns++;
    }
    
    /* takeDrink - increment both turns and drinks instance variables on every wrong player turn
     *             count up total number of drinks taken as well
     * input: none
     * return: nothing
     */
    public void takeDrink() {
        this.drinks++;
        this.turns++;
        totalDrinks++;
    }
     
    /* getTurns - fetch player turns taken
     * input: none
     * return: int - player turns dirung game
     */
    public int getTurns() {
        return this.turns;
    } 
    
    /* getDrinks - fetch player drinks taken
     * input: none
     * return: int - player drinks dirung game
     */
    public int getDrinks() {
        return this.drinks;
    }
    
    /* getId - fetch player id number
     * input: none
     * return: int - player id
     */
    public int getId() {
        return this.id;
    }
    
    /* getName - fetch player name
     * input: none
     * return: String - player name
     */
    public String getName() {
        return this.name;
    } 
    
    /* getFunds - fetch player funds
     * input: none
     * return: int - player funds
     */
    public int getFunds() {
        return this.funds;
    }
    
    /* setFunds - update player funds
     * input: int newFunds - the new funds of the player
     * return: nothing
     */
    public void setFunds( int newFunds ) {
        this.funds = newFunds;
    }
    
    //STATIC METHODS
    
    /* getNumberOfPlayers - fetch number of players in the game
     * input: none
     * return: int - total number of players in the game
     */
    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    
    /* getNumberofTotalDrinks - fetch number of total drinks taken during the game
     * input: none
     * return: int - total number of drinks during the game
     */
    public static int getNumberOfTotalDrinks() {
        return totalDrinks;
    }
}