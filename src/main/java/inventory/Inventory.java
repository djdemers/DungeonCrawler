package inventory;

import service.Item;
import service.SingleUse;
import service.Equipable;
import characters.Character;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private int gold;
    private Character owner;

    public Inventory(Character owner) {
        this.items = new ArrayList<>();
        this.gold = 0;
        this.owner = owner;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void listItems() {
        items.forEach(item -> System.out.println(item.getName()));
    }

    public Item getItem(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void useItem(String itemName) {
        Item item = getItem(itemName);
        if (item != null && item instanceof SingleUse) {
            ((SingleUse) item).use(owner);
            items.remove(item); // Remove the item after use if it's consumable
        }
    }

    public void equipItem(String itemName) {
        Item item = getItem(itemName);
        if (item != null && item instanceof Equipable) {
            ((Equipable) item).equip(owner);
            // Optionally, you might want to handle removing or disabling the item in the inventory
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isInventoryEmpty() {
        return items.isEmpty();
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public void spendGold(int amount) {
        if (this.gold >= amount) {
            this.gold -= amount;
        } else {
            throw new IllegalStateException("Not enough gold.");
        }
    }

    public int getGold() {
        return gold;
    }
}
