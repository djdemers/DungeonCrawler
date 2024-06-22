public class CharWarrior extends Character {
    public CharWarrior(String name, Race race) {
        // - Base stats for a warrior and adding race modifiers:
        // - Base Health: 150
        // - Base Attack Power: 30
        // - Base Speed: 20
        super(name, race, 150, 30, 20);
    }

    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);

    }

    public void shieldBlock() {
        System.out.println(this.name + " uses Shield Block to reduce incoming damage!");

    }


}
