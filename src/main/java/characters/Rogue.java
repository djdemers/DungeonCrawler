package characters;

import enemies.Enemy;

public class Rogue extends Character {
    public Rogue(String name, Race race){
        // - Base stats for a rogue and adding race modifiers:
        // - Base Health: 100
        // - Base Attack Power: 40
        // - Base Speed: 60
        super(name,race, 100, 40,60);
    }
    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }
}
