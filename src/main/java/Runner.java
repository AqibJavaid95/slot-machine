
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    static Scanner input = new Scanner(System.in); // Scanner allows us to capture user inputs
    static int winnings = 0; // Winnings for each spin
    static int winningsTotal = 0;


    public static void main (String[]args){

    try {  // uses a try catch block for exception handling

        System.out.println("Please enter amount of coins: ");
        int numberOfCoins = input.nextInt();

        if (numberOfCoins < 1){
            throw new InputMismatchException("Sorry you can't play with 0 coins"); // throws an input mismatch expedition
        }

        FruitMachine FM = new FruitMachine();

        for (int i = 0; i < 10; i++) {  // sets the for loop to run 10 times
            ArrayList<Symbol> result = FM.spin();

            System.out.println("Result: " + result);

            if (FM.getResult() > 0) { // if player wins returns the symbol value
                winnings += (FM.getResult() * numberOfCoins); // sets winnings to be the symbol value multiplied by coins inputted
                winningsTotal += winnings; // adds winnings per loop to running total
                System.out.println(
                        "Your winnings are: " + winnings);
            }

            if (winnings == 0) {
                System.out.println("Sorry you didn't win anything");
            }

        }
        if (winningsTotal > 0) {
            System.out.println("------------------");
            System.out.println("Your total winnings are: " + winningsTotal);
        }
        System.out.println("------------------");
        System.out.println("Insert more coins to play again");

    }

    catch(InputMismatchException inputMismatchException) {
        System.out.println("Please enter a valid integer for the number of coins");
    }

    }
}
