package characters;

import enemies.Enemy;

public abstract class Character {
    protected String name;
    protected Race race;
    protected int health;
    protected int attackPower;
    protected int speed;

    public Character(String name, Race race, int baseHealth, int baseAttackPower, int baseSpeed) {
        this.name = name;
        this.race = race;
        this.health = baseHealth + race.getHealthBonus();
        this.attackPower = baseAttackPower + race.getStrengthBonus();
        this.speed = baseSpeed + race.getAgilityBonus();
    }
    public void displayStats() {
        System.out.println(name + " the " + race + " - Health: " + health + " Attack Power: " + attackPower + " Speed: " + speed);

    }

    public void attackEnemy(Enemy target) {
        target.reduceHealth(this.attackPower);
        System.out.println(this.name + " attacks " + target.getName() + " for " + this.attackPower + " damage.");
    }

    public void heroIsHit(Enemy target){
        this.health -= target.getHealth();
        System.out.println(this.name + " was hit by " + target.getName() + " for " + target.getAttackPower());
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
    public String getName(){
        return this.name;
    }
    public int getHealth(){
        return health;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }
    public int getSpeed(){
        return speed;
    }

    public Race getRace() {
        return race;
    }
}
