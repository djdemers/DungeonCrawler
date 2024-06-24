import characters.Character;
import characters.Race;
import characters.Warrior;
import characters.decorators.ArmorDecorator;
import characters.decorators.CharacterDecorator;
import characters.decorators.DaggerDecorator;
import characters.decorators.SwordDecorator;
import enemies.Enemy;
import factories.CharacterFactory;
import factories.EnemyFactory;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());
        Character hero = CharacterFactory.createRandomCharacter("Hero");
        System.out.println(hero.getClass().getSimpleName() + " is the class you have been assigned");
        System.out.println(hero.getRace().getName() + " is the race that you have been assigned");
        System.out.println("Before any decoration:");
        hero.displayStats();

        //hero = new SwordDecorator(hero, 1);
        //System.out.println("After applying SwordDecorator:");
        //hero.displayStats();

        //((SwordDecorator) hero).unequip();
        //System.out.println("After removing ArmorDecorator:");
        //hero.displayStats();

        //hero = new ArmorDecorator(hero, 0);
        //System.out.println("After applying ArmorDecorator:");
        //hero.displayStats();

        //hero = new DaggerDecorator(hero, 1, 2);
        //System.out.println("After applying DaggerDecorator:");
        //hero.displayStats();




        GameMediator mediator = new GameMediatorImpl(hero);
        Enemy initialEnemy = EnemyFactory.createRandomSmallEnemy();
        mediator.fight(hero,initialEnemy);





    }

    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
