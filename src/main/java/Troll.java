public class Troll extends Enemy {
    public Troll() {
        super("Troll", 100, 20);
    }

    // Trolls might regenerate health, for example
    public void regenerate() {
        if (isAlive()) {
            health += 5;
        }
    }
}

