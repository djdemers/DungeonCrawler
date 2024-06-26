import characters.Character;
import characters.Race;
import characters.consumables.Consumable;
import characters.consumables.HealthPotion;
import characters.decorators.Armor;
import characters.decorators.CharacterDecorator;
import characters.decorators.Dagger;
import characters.decorators.Sword;
import enemies.Enemy;
import enemies.Goblin;
import factories.CharacterFactory;
import factories.EnemyFactory;
import factories.ItemFactory;
import inventory.Inventory;
import service.Item;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());

        //Create random generated Character
        Character hero = CharacterFactory.createRandomCharacter("Hero");
        System.out.println(hero.getClass().getSimpleName() + " is the class you have been assigned");
        System.out.println(hero.getRace().getName() + " is the race that you have been assigned");
        //Initial Stats
        System.out.println("Before any decoration:");
        hero.displayStats();

        // Create an inventory for the character
        Inventory inventory = new Inventory();

        // Create items using the factory
        Item healthPotion = ItemFactory.getItem("Health Potion");
        Item sword = ItemFactory.createItem("Sword", "Iron Sword", "A sturdy iron sword.", 10, hero);

        // Add items to the inventory
        inventory.addItem(healthPotion);
        inventory.addItem(sword);

        // Display current inventory (assuming a method exists to list items)
        System.out.println("Inventory Items:");
        inventory.listItems();  // This method needs to be implemented in Inventory class

        // Optionally, apply effects of an item, e.g., equip a sword
        if (sword instanceof Sword) {
            ((Sword)sword).apply(hero);
        }
        hero.displayStats();


        // Create item decorators
        /*CharacterDecorator sword = new Sword(hero, 5);
        CharacterDecorator armor = new Armor(hero, 3);
        CharacterDecorator dagger = new Dagger(hero, 1, 2);

        // Equip items
        hero.equipDecorator(sword);
        System.out.println("After equipping sword:");
        hero.displayStats();

        hero.equipDecorator(armor);
        System.out.println("After equipping armor:");
        hero.displayStats();

        // Remove sword
        hero.unequipDecorator(Sword.class);
        System.out.println("After removing sword:");
        hero.displayStats();

        //Equip Dagger
        hero.equipDecorator(dagger);
        System.out.println("After equipping dagger:");
        hero.displayStats();

        Enemy enemy = new Goblin();
        enemy.attackHero(hero);
        hero.displayStats();


        // Create and use a health potion
        Consumable healthPotion = new HealthPotion("Health Potion", "Restores 50 health", 50);
        System.out.println("Using Health Potion:");
        healthPotion.use(hero);
        hero.displayStats();*/


        //GameMediator mediator = new GameMediatorImpl(hero);
        //Enemy initialEnemy = EnemyFactory.createRandomSmallEnemy();
        //mediator.fight(hero,initialEnemy);





    }

    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
