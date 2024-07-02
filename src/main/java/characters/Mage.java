package characters;

import characters.skills.Fireball;
import enemies.Enemy;

public class Mage extends Character {
    public Mage(String name, Race race){
        // - Base stats for a mage and adding race modifiers:
        // - Base Health: 110
        // - Base Attack Power: 60
        // - Base Speed: 30
    super(name,race, 60, 20, 9, 1, 20);
    addSkill(new Fireball());
    }
    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }

}
