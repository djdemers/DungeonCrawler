package characters.consumables;

import characters.Character;

public class HealthPotion extends Consumable {
    private int healingAmount;

    public HealthPotion(String name, String description, int healingAmount) {
        super(name, description);
        this.healingAmount = healingAmount;
    }

    @Override
    public void use(Character character) {
        character.setHealth(Math.min(character.getHealth() + healingAmount, character.getMaxHealth()));

        System.out.println(character.getName() + " uses " + name + " and restores " + "ADD THIS LOGIC" + " health points.");
        // Remove this consumable from the inventory after use
    }
}

/*public enum ConsumableItem implements Consumable {
    HEALTH_POTION(50), SCROLL_OF_SLOW(30), SCROLL_OF_FIREBALL(25);

    private final int effectValue;

    ConsumableItem(int effectValue) {
        this.effectValue = effectValue;
    }

    @Override
    public void use(Character target) {
        switch (this) {
            case HEALTH_POTION:
                target.setHealth(Math.min(target.getHealth() + effectValue, target.getMaxHealth()));
                break;
            // ... (handle other consumables)
        }
        // Remove the item from the inventory
    }

}*/


/*public class HealthPotion implements Item, Consumable {
    private String name;
    private int healingPower;

    public HealthPotion(String name, int healingPower) {
        this.name = name;
        this.healingPower = healingPower;
    }

    @Override
    public void use(Character character) {
        character.setHealth(character.getHealth() + healingPower);
        System.out.println(character.getName() + " uses " + name + " and restores " + healingPower + " health points.");
        // This might include checks for maximum health, etc.
    }

}*/
