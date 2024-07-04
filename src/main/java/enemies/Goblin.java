package enemies;

/**
 * Represents a Goblin enemy in the game.
 * Goblins are commonly encountered enemies that pose a standard challenge to players.
 */
public class Goblin extends Enemy {

    /**
     * Constructs a Goblin with default attributes.
     * Goblins are typically weaker enemies, making them frequent early-game adversaries.
     */
    public Goblin() {
        super("Goblin", 20, 5, 5, 0);
    }
}

