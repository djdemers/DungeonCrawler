package characters;

import enemies.Enemy;

public class Mage extends Character {
    public Mage(String name, Race race){
        // - Base stats for a mage and adding race modifiers:
        // - Base Health: 110
        // - Base Attack Power: 60
        // - Base Speed: 30
    super(name,race, 110, 60, 30);
    }
    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }

}
