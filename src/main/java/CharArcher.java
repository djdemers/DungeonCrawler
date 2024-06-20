public class CharArcher extends Character {
    public CharArcher(String name, Race race){
        // - Base stats for an Archer and adding race modifiers:
        // - Base Health: 120
        // - Base Attack Power: 40
        // - Base Speed: 40
        super(name,race,120,40,40);
    }
    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }
}
