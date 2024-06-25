import characters.Character;
import characters.decorators.Armor;
import characters.decorators.CharacterDecorator;
import characters.decorators.Dagger;
import characters.decorators.Sword;
import enemies.Enemy;
import factories.CharacterFactory;
import factories.EnemyFactory;

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

        // Create item decorators
        CharacterDecorator sword = new Sword(hero, 5);
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


        GameMediator mediator = new GameMediatorImpl(hero);
        Enemy initialEnemy = EnemyFactory.createRandomSmallEnemy();
        mediator.fight(hero,initialEnemy);





    }

    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
