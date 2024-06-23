//Mediator Design Pattern from Behavioral Pattens

import characters.Character;
import enemies.Enemy;

public interface GameMediator {
    void fight(Character hero, Enemy enemy);
    void nextLevel();
    void gameOver();
}
