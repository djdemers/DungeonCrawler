package characters.consumables;

import characters.Character;
import interfaces.SingleUse;

/**
 * Represents a magic scroll that can be used by a character to unleash a magical effect without consuming mana.
 * This class extends Consumable and implements the SingleUse interface, indicating it can be used once.
 */
public class MagicScroll extends Consumable implements SingleUse {
    private int power;  // The power of the magic effect that will be unleashed.
    private int price;  // The price to acquire the scroll.

    /**
     * Constructs a MagicScroll with specified attributes.
     *
     * @param name The name of the magic scroll.
     * @param description A brief description of what the scroll does.
     * @param power The potency of the magic effect, which could represent damage, healing, or any other effect strength.
     * @param price The cost in game currency to purchase the scroll.
     */
    public MagicScroll(String name, String description, int power, int price) {
        super(name, description);
        this.power = power;
        this.price = price;
    }

    /**
     * Activates the scroll's effect on the specified character. This method simulates the use of a magical skill
     * without requiring mana from the character, typically providing an attack or a defensive maneuver.
     *
     * @param character The character who uses the scroll, affected by the scroll's magical properties.
     */
    @Override
    public void use(Character character) {
        // This could involve invoking a method that affects the game state, such as casting a spell.
        System.out.println("Using " + name + ", effect power: " + power);
    }

    /**
     * Returns the name of the scroll.
     *
     * @return The name of the scroll.
     */
    public String getName() {
        return super.name;
    }

    /**
     * Returns the price of the scroll.
     *
     * @return The cost of the scroll.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns a description of the scroll.
     *
     * @return The description of what the scroll does.
     */
    public String getDescription() {
        return super.description;
    }
}
