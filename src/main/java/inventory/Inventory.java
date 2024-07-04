package inventory;

import characters.Character;
import interfaces.Equipable;
import interfaces.Item;
import interfaces.SingleUse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the inventory for a character, including items and gold.
 * This class provides methods to add, remove, equip, and use items,
 * as well as manage gold resources.
 */
public class Inventory {
    private List<Item> items;  // List of items in the inventory
    private Map<String, Equipable> equippedItems; // Tracks equipped items by their type
    private int gold;  // Amount of gold the character has
    private Character owner;  // The character that owns this inventory

    /**
     * Constructs an Inventory for a specific character.
     *
     * @param owner The character who owns this inventory.
     */
    public Inventory(Character owner) {
        this.items = new ArrayList<>();
        this.equippedItems = new HashMap<>();
        this.gold = 0;
        this.owner = owner;
    }

    /**
     * Adds an item to the inventory. If the item is equipable, it attempts to auto-equip it.
     *
     * @param item The item to add to the inventory.
     */
    public void addItem(Item item) {
        this.items.add(item);
        if (item instanceof Equipable) {
            autoEquip((Equipable) item);
            items.remove(item);
        } else {
            System.out.println("Added " + item.getName() + " to inventory.");
        }
    }

    /**
     * Removes an item from the inventory.
     *
     * @param item The item to be removed.
     */
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    /**
     * Lists all items in the inventory along with the current gold amount.
     */
    public void listItems() {
        System.out.println("INVENTORY:");
        items.forEach(item -> System.out.println(item.getName()));
        System.out.println("Current Gold: " + gold);
    }

    /**
     * Retrieves an item by its name from the inventory.
     *
     * @param name The name of the item to retrieve.
     * @return The item if found, otherwise null.
     */
    public Item getItem(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Uses a named item if it is consumable.
     *
     * @param itemName The name of the item to use.
     */
    public void useItem(String itemName) {
        Item item = getItem(itemName);
        if (item != null && item instanceof SingleUse) {
            ((SingleUse) item).use(owner);
            items.remove(item); // Remove the item after use if it's consumable
            System.out.println(itemName + " used.");
        }
    }

    /**
     * Equips an item by name if it is equipable.
     *
     * @param itemName The name of the item to equip.
     */
    public void equipItem(String itemName) {
        Item item = getItem(itemName);
        if (item instanceof Equipable) {
            Equipable equipableItem = (Equipable) item;
            autoEquip(equipableItem);
            items.remove(item);
        }
    }

    /**
     * Automatically equips a new item, comparing it with already equipped items of the same type.
     * Replaces the currently equipped item if the new item has a higher bonus.
     *
     * @param newItem The new item to be equipped.
     */
    private void autoEquip(Equipable newItem) {
        String type = newItem.getType();
        Equipable currentlyEquipped = equippedItems.get(type);

        if (currentlyEquipped == null || newItem.getBonus() > currentlyEquipped.getBonus()) {
            if (currentlyEquipped != null) {
                currentlyEquipped.unequip(owner);
            }
            equippedItems.put(type, newItem);
            newItem.equip(owner);
        }
    }

    /**
     * Uses a health potion if the owner's health is below 25% of maximum health.
     */
    public void useHealthPotionIfNecessary() {
        if (owner.getHealth() < owner.getMaxHealth() / 4) {
            Item healthPotion = getItem("Health Potion");
            if (healthPotion != null) {
                ((SingleUse) healthPotion).use(owner);
                items.remove(healthPotion);
            }
        }
    }

    /**
     * Uses a mana potion if the owner's mana is below 10.
     */
    public void useManaPotionIfNecessary() {
        if (owner.getMana() < 10) {
            Item manaPotion = getItem("Mana Potion");
            if (manaPotion != null) {
                ((SingleUse) manaPotion).use(owner);
                items.remove(manaPotion);
            }
        }
    }

    /**
     * Returns the number of items in the inventory.
     *
     * @return The number of items.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Checks if the inventory is empty.
     *
     * @return true if the inventory has no items, false otherwise.
     */
    public boolean isInventoryEmpty() {
        return items.isEmpty();
    }

    /**
     * Adds a specified amount of gold to the inventory.
     *
     * @param amount The amount of gold to add.
     */
    public void addGold(int amount) {
        this.gold += amount;
    }

    /**
     * Spends a specified amount of gold if sufficient funds are available.
     *
     * @param amount The amount of gold to spend.
     * @throws IllegalStateException If there is not enough gold to spend.
     */
    public void spendGold(int amount) {
        if (this.gold >= amount) {
            this.gold -= amount;
        } else {
            throw new IllegalStateException("Not enough gold.");
        }
    }

    /**
     * Gets the current amount of gold in the inventory.
     *
     * @return The current gold amount.
     */
    public int getGold() {
        return gold;
    }
}
