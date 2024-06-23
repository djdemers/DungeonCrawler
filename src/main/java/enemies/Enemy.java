package enemies;

import characters.Character;

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


    public void enemyIsHit(Character target) {
        this.health -= target.getAttackPower();
        System.out.println(this.name + " was hit by " + target.getName() + " for " + target.getAttackPower());
    }

    public void attackHero(Character target) {
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
    public int getHealth(){
        return health;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int getSpeed(){
        return speed;
    }
}

