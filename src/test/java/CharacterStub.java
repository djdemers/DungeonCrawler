import characters.Character;
import characters.Race;

class CharacterStub extends Character {
    private int health = 100;
    private int maxHealth = 100;

    /**
     * Constructs a new character with specified attributes and race modifiers.
     *
     * @param name            the name of the character
     * @param race            the race of the character, which modifies base attributes
     * @param baseHealth      the base health of the character before racial modifiers
     * @param baseAttackPower the base attack power of the character before racial modifiers
     * @param baseSpeed       the base speed of the character before racial modifiers
     * @param baseDefense
     */
    public CharacterStub(String name, Race race, int baseHealth, int baseAttackPower, int baseSpeed, int baseDefense) {
        super(name, race, baseHealth, baseAttackPower, baseSpeed, baseDefense);
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    // Implement other necessary methods or add more functionality as needed
}
