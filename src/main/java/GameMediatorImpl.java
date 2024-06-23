import java.util.ArrayList;
import java.util.List;

public class GameMediatorImpl implements GameMediator {
    private Character hero;
    private List<Enemy> enemies;
    private int currentLevel = 1;

    public GameMediatorImpl(Character hero) {
        this.hero = hero;
        this.enemies = new ArrayList<>();
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
            System.out.println(hero.getName() + " has defeated " + enemy.getName() + "!");
            //nextLevel(hero);
        }
    }

    @Override
    public void nextLevel(Character hero) {
        currentLevel++;
        System.out.println("Welcome to level " + currentLevel);
        Enemy nextEnemy = EnemyFactory.createEnemy("next_level_enemy_type");
        enemies.add(nextEnemy);
        fight(hero, nextEnemy);
    }

    @Override
    public void gameOver() {
        System.out.println("Game Over. " + hero.getName() + " reached level " + currentLevel + ".");
    }
}
