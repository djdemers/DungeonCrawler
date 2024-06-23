public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());

        Character hero = new CharRogue("Sneak", Race.FAIRY);
        hero.displayStats();
        GameMediator mediator = new GameMediatorImpl(hero);
        Enemy initialEnemy = EnemyFactory.createEnemy("goblin");
        mediator.fight(hero,initialEnemy);



       hero = new SwordDecorator(hero, 10);
       hero.displayStats();

    }

    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
