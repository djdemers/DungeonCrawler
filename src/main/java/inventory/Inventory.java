package inventory;

import service.Item;
import service.SingleUse;
import service.Equipable;
import characters.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Item> items;
    private Map<String, Equipable> equippedItems; // Track equipped items by type
    private int gold;
    private Character owner;

    public Inventory(Character owner) {
        this.items = new ArrayList<>();
        this.equippedItems = new HashMap<>();
        this.gold = 0;
        this.owner = owner;
    }

    public void addItem(Item item) {
        this.items.add(item);
        if (item instanceof Equipable) {
            autoEquip((Equipable) item);
        } else {
            System.out.println("Added " + item.getName() + " to inventory.");
        }
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void listItems() {
        System.out.println("Inventory:" );
        items.forEach(item -> System.out.println(item.getName()));
        System.out.println("Current Gold: " + gold);
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
            System.out.println(itemName + " used.");
        }
    }

    public void equipItem(String itemName) {
        Item item = getItem(itemName);
        if (item instanceof Equipable) {
            Equipable equipableItem = (Equipable) item;
            autoEquip(equipableItem);
            items.remove(item);
        }
    }
    public void autoEquip(Equipable newItem) {
        String type = newItem.getType();
        Equipable currentlyEquipped = equippedItems.get(type);

        if (currentlyEquipped == null || newItem.getBonus() > currentlyEquipped.getBonus()) {
            if (currentlyEquipped != null) {
                currentlyEquipped.unequip(owner);
            }
            equippedItems.put(type, newItem);
            owner = newItem.equip(owner);
            System.out.println("Equipped " + newItem.getName());
        }
    }
    public void useHealthPotionIfNecessary() {
        if (owner.getHealth() < owner.getMaxHealth() / 2) {
            Item healthPotion = getItem("Health Potion");
            if (healthPotion != null) {
                ((SingleUse) healthPotion).use(owner);
                items.remove(healthPotion);
                System.out.println("Used " + healthPotion.getName() + " to restore health.");
            }
        }
    }

    public void useManaPotionIfNecessary() {
        if (owner.getMana() < owner.getMaxMana() / 2) {
            Item manaPotion = getItem("Mana Potion");
            if (manaPotion != null) {
                ((SingleUse) manaPotion).use(owner);
                items.remove(manaPotion);
                System.out.println("Used " + manaPotion.getName() + " to restore mana.");
            }
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
