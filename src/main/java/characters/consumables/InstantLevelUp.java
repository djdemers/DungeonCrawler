package characters.consumables;

import characters.Character;
import interfaces.SingleUse;

/**
 * Represents a consumable item that instantly increases the character's level
 * when used. This is a powerful item intended for rapid progression.
 */
public class InstantLevelUp extends Consumable implements SingleUse {
    private int price;
    private int levelIncrement;

    /**
     * Constructs a new InstantLevelUp item.
     *
     * @param name The name of the item.
     * @param description A brief description of the item's effects.
     * @param levelIncrement The number of levels the character will gain upon using this item.
     * @param price The price of the item if bought or sold.
     */
    public InstantLevelUp(String name, String description, int levelIncrement, int price) {
        super(name, description);
        this.levelIncrement = levelIncrement;
        this.price = price;
    }

    /**
     * Applies the effect of the item to the specified character, increasing their level.
     * Currently, the actual level-up logic is commented out and needs implementation.
     *
     * @param character The character who uses the item and benefits from its effects.
     */
    @Override
    public void use(Character character) {
        // character.levelUp(); // Uncomment and implement this method in the Character class to actually increase the level.
        System.out.println(character.getName() + " uses " + name + " and levels up instantly!");
    }

    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return super.name;
    }

    /**
     * Returns the price of the item.
     *
     * @return The price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return super.description;
    }
}