package enemies;

/**
 * Represents a Spider enemy in the game.
 * Spiders are nimble and common enemies that players may encounter across various levels.
 */
public class Spider extends Enemy {

    /**
     * Constructs a new Spider with predefined attributes.
     * Spiders, like rats, are small and common, but they can be a bit trickier due to their agility.
     */
    public Spider() {
        super("Spider", 20, 5, 5, 0);
    }
}
