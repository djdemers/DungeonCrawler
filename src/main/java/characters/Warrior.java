package characters;

import enemies.Enemy;

public class Warrior extends Character {
    public Warrior(String name, Race race) {
        // - Base stats for a warrior and adding race modifiers:
        // - Base Health: 150
        // - Base Attack Power: 30
        // - Base Speed: 20
        super(name, race, 80, 10, 5, 5, 5);
    }

    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);

    }

    public void shieldBlock() {
        System.out.println(this.name + " uses Shield Block to reduce incoming damage!");

    }


}
