package characters;

import enemies.Enemy;

public class Archer extends Character {
    public Archer(String name, Race race){
        // - Base stats for an Archer and adding race modifiers:
        // - Base Health: 120
        // - Base Attack Power: 40
        // - Base Speed: 40
        super(name,race,80,12,5, 3, 10);
    }
    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }
}
