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
import inventory.Inventory;

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

        Inventory inventory = new Inventory();
        HealthPotion healthPotion = new HealthPotion("Health Potion", "Heal you", 25);

        // Add items to the inventory
        System.out.println("Adding a health potion to the inventory.");
        inventory.addItem(healthPotion);

        // Display initial inventory count
        System.out.println("Current items in inventory: " + inventory.getItemCount());

        // Use the health potion
        System.out.println("Using the health potion...");
        inventory.useItem("Health Potion", hero);
        System.out.println("Health after using potion: " + hero.getHealth());

        // Check if inventory is empty after use
        System.out.println("Current items in inventory: " + inventory.getItemCount());

        // Add and spend gold
        System.out.println("Adding gold to the inventory...");
        inventory.addGold(100);
        System.out.println("Current gold: " + inventory.getGold());

        System.out.println("Spending 50 gold...");
        inventory.spendGold(50);
        System.out.println("Current gold after spending: " + inventory.getGold());

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
