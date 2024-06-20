public abstract class Enemy {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int speed;

    public Enemy(String name, int health, int attackPower, int speed) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.speed = speed;
    }
    public void displayStats() {
        System.out.println(name + " - Health: " + health + ", Attack Power: " + attackPower);
        System.out.println("Speed: " + speed);
    }

    public void attackHero(Character target) {
        target.health -= this.attackPower;
        System.out.println(this.name + " attacks " + target.name + " for " + this.attackPower + " damage.");
    }
    public void enemyIsHit(Character target){
        this.health -= target.attackPower;
        System.out.println(this.name + " was hit by " + target.name + " for " + target.attackPower);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
    }

    public String getName() {
        return name;
    }
}
