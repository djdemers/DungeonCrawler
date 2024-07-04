package enemies;

/**
 * Represents a Bear enemy in the game.
 * Bears are powerful foes with significant attack strength but relatively low speed,
 * making them formidable opponents in close combat.
 */
public class Bear extends Enemy {

    /**
     * Constructs a new Bear with predefined attributes.
     * Bears are characterized by their high attack power and substantial health,
     * which make them challenging enemies on intermediate floors.
     */
    public Bear() {
        super("Bear", 60, 15, 1, 0);
    }
}
