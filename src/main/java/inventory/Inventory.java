package inventory;

import characters.consumables.Consumable;
import characters.decorators.CharacterDecorator;
import characters.Character;
import service.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The Inventory class manages a collection of items and gold within a game.
 * It allows adding and removing items, using consumable items, and managing gold.
 */
public class Inventory {
    private List<Item> items;  // General items list
    private int gold;

    /**
     * Constructs an Inventory with an empty list of items and no gold.
     */
    public Inventory() {
        this.items = new ArrayList<>();
        this.gold = 0;
    }

    /**
     * Adds an item to the inventory.
     * @param item The item to be added.
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Uses an item by its name, applying its effects to a specified character, and then removes it from the inventory.
     * Only items that are instances of Consumable can be used.
     * @param itemName The name of the item to use.
     * @param character The character on whom the item is to be used.
     */
    public void useItem(String itemName, Character character) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().equals(itemName) && item instanceof Consumable) {
                ((Consumable)item).use(character);
                items.remove(i);  // Remove the item by index to avoid ConcurrentModificationException
                break;
            }
        }
    }

    /**
     * Removes an item from the inventory and reverts any effects it had on the character.
     * @param item The decorator item to be removed.
     * @param character The character from whom the decorator's effects will be removed.
     */
    public void removeItem(CharacterDecorator item, Character character) {
        item.revert(character);
        items.remove(item);
    }

    /**
     * Returns the count of items in the inventory.
     * @return The number of items currently in the inventory.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Checks if the inventory is empty.
     * @return true if the inventory has no items, false otherwise.
     */
    public boolean isInventoryEmpty() {
        return items.isEmpty();
    }

    /**
     * Adds gold to the inventory.
     * @param amount The amount of gold to add.
     */
    public void addGold(int amount) {
        this.gold += amount;
    }

    /**
     * Spends a specified amount of gold if sufficient gold is available.
     * @param amount The amount of gold to spend.
     * @throws IllegalStateException if there is not enough gold.
     */
    public void spendGold(int amount) {
        if (amount <= this.gold) {
            this.gold -= amount;
        } else {
            throw new IllegalStateException("Not enough gold.");
        }
    }

    /**
     * Returns the current amount of gold in the inventory.
     * @return The amount of gold.
     */
    public int getGold() {
        return gold;
    }
}

