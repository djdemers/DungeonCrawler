public abstract class Enemy {
    protected String name;
    protected int health;
    protected int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    public void displayStats() {
        System.out.println(name + " - Health: " + health + ", Attack Power: " + attackPower);
    }

    public void attack(Character target) {
        target.reduceHealth(this.attackPower);
        System.out.println(this.name + " attacks " + target.getName() + " for " + this.attackPower + " damage.");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public String getName() {
        return name;
    }
}

