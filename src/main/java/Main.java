import characters.Character;
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
        hero.displayStats();
        GameMediator mediator = new GameMediatorImpl(hero);
        Enemy initialEnemy = EnemyFactory.createRandomSmallEnemy();
        mediator.fight(hero,initialEnemy);



       hero = new SwordDecorator(hero, 10);
       hero.displayStats();

    }

    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
