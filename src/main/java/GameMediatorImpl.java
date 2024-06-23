import characters.Character;
import enemies.Enemy;
import factories.EnemyFactory;
import java.util.List;

public class GameMediatorImpl implements GameMediator {
    private Character hero;
    private int currentLevel = 1;

    public GameMediatorImpl(Character hero) {
        this.hero = hero;
    }

    @Override
    public void fight(Character hero, Enemy enemy) {
        while (hero.isAlive() && enemy.isAlive()) {
            hero.attackEnemy(enemy);
            if (enemy.isAlive()) {
                enemy.attackHero(hero);
            }
        }
        if (!hero.isAlive()) {
            gameOver();
        } else {
            System.out.println(hero.getName() + " has defeated " + enemy.getClass().getSimpleName() + "!");
            nextLevel();
        }
    }

    public void nextLevel() {
        currentLevel++;
        Enemy enemy;
        if (currentLevel % 10 == 0) {
            enemy = EnemyFactory.createRandomBoss();
        } else if (currentLevel % 5 == 0) {
            enemy = EnemyFactory.createRandomMediumEnemy();
        } else {
            enemy = EnemyFactory.createRandomSmallEnemy();
        }
        System.out.println("Welcome to level " + currentLevel);
        fight(hero, enemy);
    }

    @Override
    public void gameOver() {
        System.out.println("Game Over. " + hero.getName() + " reached level " + currentLevel + ".");
    }
}
