public abstract class Character {
    protected String name;
    protected  Race race;
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
        System.out.println(name + " - Health: " + health + ", Attack Power: " + attackPower);
        System.out.println("Speed: " + speed);
    }
    public void attackEnemy(Enemy target) {
        target.health -= this.attackPower;
        System.out.println(this.name + " attacks " + target.name + " for " + this.attackPower + " damage.");
    }
    public void heroIsHit(Enemy target){
        this.health -= target.attackPower;
        System.out.println(this.name + " was hit by " + target.name + " for " + target.attackPower);
    }


}
