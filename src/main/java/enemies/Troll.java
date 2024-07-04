package enemies;

/**
 * Represents a Troll enemy in the game.
 * Trolls are a type of enemy characterized by their ability to regenerate health each turn,
 * making them a persistent threat in combat scenarios.
 */
public class Troll extends Enemy {

    /**
     * Constructs a new Troll with predefined attributes.
     * The attributes include a high health value and moderate attack power,
     * but low speed and no innate defense capabilities.
     */
    public Troll() {
        super("Troll", 70, 10, 1, 0);
    }

    /**
     * Regenerates health for the Troll.
     * If the Troll is alive, this method increases its health by 5 points each time it is called.
     * This regeneration ability helps the Troll recover from damage over time,
     * making it a challenging enemy for players to defeat.
     */
    public void regenerate() {
        if (isAlive()) {
            health += 5;
            System.out.println("Troll regenerates 5 health, new health: " + health);
        }
    }
}

