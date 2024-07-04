package enemies;

/**
 * Represents a Rat enemy in the game.
 * Rats are small and common enemies, usually encountered frequently by players at lower levels.
 */
public class Rat extends Enemy {

    /**
     * Constructs a new Rat with predefined attributes.
     * Rats are characterized by low health and moderate speed, making them weaker but potentially
     * quick adversaries in the game.
     */
    public Rat() {
        super("Rat", 20, 5, 5, 0);
    }
}

