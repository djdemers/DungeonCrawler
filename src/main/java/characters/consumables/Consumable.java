package characters.consumables;
import characters.Character;

/**
 * Abstract class representing a consumable item in the game.
 * Consumables are items that can be used once to affect a character,
 * typically providing healing, buffing, or other effects.
 */
public abstract class Consumable {
    protected String name;
    protected String description;

    /**
     * Constructs a new Consumable item with the specified name and description.
     *
     * @param name The name of the consumable item.
     * @param description A brief description of the consumable item.
     */
    public Consumable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Uses the consumable item on a specified character, applying its effects.
     *
     * @param character The character on whom the consumable will be used.
     */
    public abstract void use(Character character);
}
