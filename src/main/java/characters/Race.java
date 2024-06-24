package characters;

/**
 * Enum representing the various races available in the game.
 * Each race has unique bonuses to health, agility, and strength.
 */
public enum Race {
    HUMAN("Human", 2, 2, 2, 0),
    ELF("Elf", 1, 3, 2, 0),
    DWARF("Dwarf", 3, 2, 1, 0),
    ORC("Orc", 1, 4, 1, 0),
    FAIRY("Fairy", 1, 0, 5, 0);

    private final String name;
    private final int healthBonus;
    private final int agilityBonus;
    private final int strengthBonus;
    private final int defenseBonus;

    /**
     * Constructs a race with specified name and attribute bonuses.
     *
     * @param name the name of the race
     * @param healthBonus the health bonus for the race
     * @param agilityBonus the agility bonus for the race
     * @param strengthBonus the strength bonus for the race
     */
    Race(String name, int healthBonus, int strengthBonus, int agilityBonus, int defenseBonus) {
        this.name = name;
        this.healthBonus = healthBonus;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.defenseBonus = defenseBonus;
    }

    /**
     * Returns the name of the race.
     *
     * @return the name of the race
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a random race from the defined races.
     *
     * @return a randomly selected race
     */
    public static Race getRandomRace() {
        return values()[(int) (Math.random() * values().length)];
    }

    /**
     * Returns the health bonus of the race.
     *
     * @return the health bonus
     */
    public int getHealthBonus() {
        return healthBonus;
    }

    /**
     * Returns the agility bonus of the race.
     *
     * @return the agility bonus
     */
    public int getAgilityBonus() {
        return agilityBonus;
    }

    /**
     * Returns the strength bonus of the race.
     *
     * @return the strength bonus
     */
    public int getStrengthBonus() {
        return strengthBonus;
    }

    /**
     * Returns the defense bonus of the race.
     *
     * @return the defense bonus
     */
    public int getDefenseBonus(){
        return defenseBonus;
    }
}

