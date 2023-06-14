import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class FruitMachine {

    private final ArrayList<Symbol> reels;
    private int result;

    public FruitMachine() {
        this.reels = new ArrayList<>();

    }

    public Symbol getRandomSymbol(){
        Random random = new Random(); // gets a new instance of the Java Random class
        int i = random.nextInt(Symbol.values().length); // picks a random int between 0 and the length of the enum (4)
        Symbol[] values = Symbol.values(); // values holds a simple array of Enum values
        return values[i]; // returns one random Enum value
    }

    public int getResult() {
        return result;
    }

    public ArrayList<Symbol> spin() {
        this.reels.clear(); // Reset the spin arraylist
        this.result = 0;  // Reset the result
        this.reels.add(getRandomSymbol()); // Adds 3 random symbols to the spin arraylist
        this.reels.add(getRandomSymbol());
        this.reels.add(getRandomSymbol());
        if (this.reels.get(0) == this.reels.get(1) && this.reels.get(1) == this.reels.get(2) ){ // checks all 3 enums match to win
            result = this.reels.get(0).getWinnings(); // gets the winnings value from the enum
        }
        return this.reels;
    }
}
