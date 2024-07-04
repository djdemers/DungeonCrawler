import characters.Character;

import enemies.EnemyLeveling;
import factories.CharacterFactory;
import interfaces.EnemyScalingStrategy;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());

        // Create a character using a factory method
        EnemyScalingStrategy scalingStrategy = new EnemyLeveling();
        Character hero = CharacterFactory.createRandomCharacter("Hero");
        System.out.println(hero.getClass().getSimpleName() + " is the class you have been assigned");
        System.out.println(hero.getRace().getName() + " is the race that you have been assigned");


        // Example combat scenario
        GameMediator mediator = new GameMediatorImpl(hero, scalingStrategy);
        mediator.nextLevel();
    }
    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
