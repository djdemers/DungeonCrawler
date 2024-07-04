import characters.Character;

import enemies.Enemy;
import enemies.EnemyLeveling;
import factories.CharacterFactory;
import factories.EnemyFactory;
import interfaces.EnemyScalingStrategy;
import interfaces.Equipable;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());
        EnemyScalingStrategy scalingStrategy = new EnemyLeveling();

        //REQUIREMENT 1 and 2
        ////////////////////////////////////////////////////////////////////////////////////////////////
        //The factory method createRandomCharacter encapsulates the logic for creating characters
        // with randomly assigned classes and races. It promotes loose coupling between the
        // character creation code and the rest of the game's codebase.
        Character hero = CharacterFactory.createRandomCharacter("Hero");
        System.out.println(hero.getClass().getSimpleName() + " is the class you have been assigned");
        System.out.println(hero.getRace().getName() + " is the race that you have been assigned");
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        //REQUIREMENT 3
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //When the player progresses to a new floor, the game correctly generates an enemy based on the floor level.
        // This includes: Small enemies on most floors. Medium enemies on every fifth floor. Boss enemies on
        // every tenth floor.
        // SEE:  private Enemy generateEnemyForCurrentLevel() in GameMediatorImpl.java line 154

        //REQUIREMENT 4
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //The game correctly manages item equipping, ensuring that only the best items are equipped for any given type.
        //The player does not need to manually switch items unless they choose to, simplifying the gameplay and
        // focusing on strategy rather than inventory management.
        //SEE : public void autoEquip used in Inventory.java line 115

        //REQUIREMENT 5
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //At the end of each battle, the game checks a random probability to decide whether a chest appears,
        // a shop is found, or nothing occurs.
        // SEE: triggerRandomEvent(Character hero) in GameMediatorImpl.java line 168.

        //REQUIREMENT 6
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Each time a shop event is triggered, the shop generates its inventory afresh with three items selected at random.
        // This selection includes a balanced mix of weapons, scrolls, potions, and occasionally a rare item for
        // instant level-up. The Shop class uses the ItemFactory to create items based on randomized criteria,
        // ensuring a varied experience every time a shop is encountered.
        // SEE: private void openShop(Character hero) in GameMediatorImpl.java line 210

        //REQUIREMENT 7
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Potions are designed to restore a specific amount of health or mana but include logic to check the
        // character's current health or mana before application. The system calculates the difference between
        // the character's current and maximum health or mana to determine the effective amount to restore.
        // SEE: HealthPotion.java

        //REQUIREMENT 8
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //After each combat encounter and shop visit, the game checks if the hero's health has dropped below 15%
        // of the maximum health. If the health criterion is met, the game automatically transports
        // the hero to the top floor, resetting both health and mana to their maximum values.
        // SEE: private void handlePostBattle in GameMediatorImpl.java line 101

        //REQUIREMENT 9
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //An EnemyScalingStrategy interface is implemented, which defines how enemy attributes are adjusted as the
        // player progresses to higher floors.The EnemyLeveling class, which implements this strategy, modifies
        // the health, attack power, defense, and speed of enemies based on the floor number.

        // Example combat scenario
        GameMediator mediator = new GameMediatorImpl(hero, scalingStrategy);
        mediator.nextLevel();
    }
    public String getGreeting() {
        return "Welcome to the Dungeon!";
    }
}
