import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static Scanner sc = new Scanner(System.in);

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};
    public static void main(String[] args) {
        
        String a = randomWord();
        char[] placeholders = new char[a.length()];

        for(int i = 0; i < a.length(); i++){
            placeholders[i] = '_';
        }

       int misses = 0;

       char[] missedGuesses = new char[6];
       while(misses < 6){
        System.out.print(gallows[misses]);

        System.out.print("Word : ");
        printPlaceHolders(placeholders);
        System.out.println("\n");

        System.out.print("Misses:   ");
        printMissedGuesses(missedGuesses);
        System.out.println("\n");

        System.out.print("Guess:   ");
        char guess = sc.nextLine().charAt(0);
        System.out.print("\n");

        if(checkGuess(a, guess)){
            updatePlaceholders(a, placeholders, guess);
        } else{
            missedGuesses[misses] = guess;
            misses++;
        }

        if(Arrays.equals(placeholders, a.toCharArray())){
            System.out.print(gallows[misses]);
            System.out.print("\nWord:   ");
            printPlaceHolders(placeholders);
            System.out.println("\nGOOD WORK!");                
            break;
        }

        if (misses == 6) {
            System.out.print(gallows[6]);
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + a + "'");
        }

       }
        
    }
    public static String randomWord(){
        String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
        "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
        "wombat", "zebra"};

        Random r = new Random();
        int x = r.nextInt(words.length);
        return words[x];
    }

    public static boolean checkGuess(String a, char guess){
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == guess){
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceholders(String a, char[] placeholders, char guess){
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == guess){
                placeholders[i] = guess;
            }
        }
    }

    public static void printPlaceHolders(char[] placeholders){
        for(int i = 0; i < placeholders.length; i++){
            System.out.print(placeholders[i] + " ");
        }
        System.out.println("\n");
    }

    public static void printMissedGuesses(char[] missedGuesses){
        for(int i = 0; i < 6; i++){
            System.out.println(missedGuesses[i] + " ");
        } 
    }
}
