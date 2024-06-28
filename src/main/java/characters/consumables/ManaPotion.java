package characters.consumables;

import characters.Character;
import service.SingleUse;

/**
 * Represents a mana potion that can be used by a character to restore mana.
 * This potion ensures that the character's mana does not exceed their maximum allowable mana.
 */
public class ManaPotion extends Consumable implements SingleUse {
    private int manaAmount;

    /**
     * Constructs a new Mana Potion with a specified name, description, and restore amount.
     *
     * @param name The name of the mana potion.
     * @param description A brief description of the mana potion's effects.
     * @param manaAmount The amount of health this potion will restore when used.
     */
    public ManaPotion(String name, String description, int manaAmount) {
        super(name, description);
        this.manaAmount = manaAmount;
    }

    /**
     * Uses the potion on a character, restoring a specified amount of mana,
     * without exceeding the character's maximum mana.
     *
     * @param character The character on whom the potion is used.
     */
    @Override
    public void use(Character character) {
        int originalMana = character.getMana();
        int newMana = Math.min(character.getMana() + manaAmount, character.getMaxMana());
        character.setMana(newMana);

        int manaRestoration = newMana - originalMana;
        System.out.println(character.getName() + " uses " + name + " and restores " + manaRestoration + " mana points.");
        // Remove this consumable from the inventory after use
    }

    /**
     * Returns the name of the health potion.
     *
     * @return The name of the potion.
     */
    public String getName(){
        return super.name;
    }

}