public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());
        Character mage = CharacterFactory.createCharacter("mage", "Gug",  Race.ORC );
        Character warrior = CharacterFactory.createCharacter("warrior", "Fred", Race.HUMAN);
        Character archer = CharacterFactory.createCharacter("archer", "Lego", Race.ELF);
        //Mage mage = new Mage("one");
        //System.out.println(mage.getName());
        //mage.displayStats();
        //warrior.displayStats();
        //archer.displayStats();

        Enemy goblin1 = EnemyFactory.createEnemy("goblin");
        Enemy goblin2 = EnemyFactory.createEnemy("goblin");
        Enemy troll1 = EnemyFactory.createEnemy("troll");
        Enemy dragon1 = EnemyFactory.createEnemy("dragon");

        goblin1.displayStats();
        troll1.displayStats();
        dragon1.displayStats();

        mage.attackEnemy(goblin1);
        goblin1.displayStats();
        goblin1.attackHero(mage);
        mage.displayStats();
        SwordDecorator mageDeco = new SwordDecorator(mage, 5);
        mageDeco.attackEnemy(goblin2);
        mageDeco.displayStats();

    }

    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
