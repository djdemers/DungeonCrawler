package enemies;

import characters.Character;

public class Dragon extends Enemy {
    public Dragon() {
        super("Dragon", 200, 40, 90);
    }


    public void fireBreath(Character target) {
        int fireDamage = 60;
        target.reduceHealth(fireDamage);
        System.out.println("The dragon breathes fire, causing " + fireDamage + " damage to " + target.getName());
    }
}
