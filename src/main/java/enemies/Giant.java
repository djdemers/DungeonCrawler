package enemies;

/**
 * Represents a Giant enemy in the game.
 * Giants are large and powerful enemies with significant health and defensive capabilities.
 */
public class Giant extends Enemy {

    /**
     * Constructs a new Giant with predefined attributes.
     * Giants are characterized by their high health, decent attack power, and substantial defense,
     * making them tough opponents in battle.
     */
    public Giant() {
        super("Giant", 80, 15, 10, 5);
    }
}
