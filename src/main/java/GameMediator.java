public interface GameMediator {
    void fight(Character hero, Enemy enemy);
    void nextLevel(Character hero);
    void gameOver();
}
