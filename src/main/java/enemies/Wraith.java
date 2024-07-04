package enemies;

/**
 * Represents a Wraith enemy in the game.
 * Wraiths are ethereal creatures known for their high attack power and moderate speed,
 * presenting a unique challenge due to their ability to deal significant damage.
 */
public class Wraith extends Enemy {

    /**
     * Constructs a new Wraith with predefined attributes.
     * Wraiths have high attack values and average speed but no innate defense,
     * making them deadly strikers but vulnerable to counterattacks.
     */
    public Wraith() {
        super("Wraith", 50, 20, 3, 0);
    }
}
