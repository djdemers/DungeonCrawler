package characters.skills;

import characters.Character;
import characters.Mage;

public class Fireball extends Skill {
    private int damage;

    public Fireball() {
        super("Fireball", "A fiery explosive projectile that deals damage.", 3,20, 1);
        this.damage = 50;
    }

    @Override
    public void activate(Character caster, Character target) {
        if (!(caster instanceof Mage)) {
            System.out.println("This skill is only available to Mages.");
            return;
        }
        if (isAvailable(caster)) {
            applyBoost(caster);
        } else {
            System.out.println("Not enough mana or skill is on cooldown.");
        }
    }
    private void applyBoost(Character caster) {
        caster.setAttackPower(caster.getAttackPower() + damage);
        System.out.println(caster.getName() + " uses " + getName() + ", increasing attack power by " + damage + ".");
    }

    @Override
    public void deactivate(Character caster) {
        caster.setAttackPower(caster.getAttackPower() - damage);
        System.out.println(getName() + " effect ends, decreasing " + caster.getName() + "'s attack power by " + damage + ".");
    }
}
