import java.util.HashMap;

/**
 * Lab 8
 *
 * An enumeration containing the possible hand choices that a player can make
 * in Rock-Paper-Scissors.
 *
 * @author Stephen
 * @version 2018-03-12
 */
public enum HandChoice
{
    /**
     * The Player chooses Rock.
     */
    ROCK,

    /**
     * The Player chooses Paper.
     */
    PAPER,

    /**
     * The Player chooses Scissors.
     */
    SCISSORS;

    /**
     * Maps a Hand choice to the Hand choice that it wins against.
     * I.e. a key in the strength map wins against the associate value.
     * E.g. you might put the pair ROCK, SCISSORS into the map, because
     * ROCK wins against SCISSORS. ROCK would be the key and SCISSORS would
     * be the associated value.
     */
    private static final HashMap<HandChoice, HandChoice> CHOICE_MAP;

    /* This is the static initializer, run when the class is first loaded. */
    static
    {
        // TODO: implement this. You should initialize and populate (load entries into) the CHOICE_MAP.
    }

    /**
     * Method that gives the hand choice that this hand choice wins against.
     *
     * @return The HandChoice that this type wins against. e.g. if the enum
     * is type Rock, the result of winsAgainst should be Scissors.
     */
    public HandChoice winsAgainst()
    {
        // TODO: implement this.
    }

    /**
     * Returns the enum's name in lowercase.
     * 
     * @return The name of the enum as a lowercase string.
     */
    @Override
    public String toString()
    {
        // TODO: implement this.
    }
}
