import characters.Character;
import enemies.Enemy;

/**
 * Defines the mediator interface for managing interactions in a game setting.
 * This interface is part of the Mediator design pattern and is used to encapsulate
 * how a set of objects interact. It promotes loose coupling by keeping objects
 * from referring to each other explicitly and it lets you vary their interactions independently.
 * The GameMediator coordinates various game actions such as combat and level progression.
 */
public interface GameMediator {

    /**
     * Initiates and manages a fight sequence between a hero and an enemy.
     * The method continues to handle the battle process until one of the parties is defeated.
     *
     * @param hero The hero character controlled by the player.
     * @param enemy The enemy character the hero is fighting against.
     */
    void fight(Character hero, Enemy enemy);

    /**
     * Advances the game to the next level.
     * This typically involves setting up the environment for the next level,
     * which may include generating new enemies or resetting certain game states.
     */
    void nextLevel();

    /**
     * Ends the game with a loss. This method is called when conditions for a game over are met,
     * typically when the hero is defeated.
     */
    void gameOver();
}

