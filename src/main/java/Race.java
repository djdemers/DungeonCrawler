public enum Race {
    HUMAN("Human", 5, 5, 5),
    ELF("Elf", 4, 6, 7),
    DWARF("Dwarf", 8, 3, 4),
    ORC("Orc", 10, 2, 3),
    FAIRY("Fairy", 3, 10,4);

    private final String name;
    private final int healthBonus;
    private final int agilityBonus;
    private final int strengthBonus;


    Race(String name, int healthBonus, int agilityBonus, int strengthBonus) {
        this.name = name;
        this.healthBonus = healthBonus;
        this.agilityBonus = agilityBonus;
        this.strengthBonus = strengthBonus;
    }

    public String getName() {
        return name;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public int getAgilityBonus() {
        return agilityBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }
}
