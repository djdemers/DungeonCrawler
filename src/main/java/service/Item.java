package util;

public interface Item {
    void apply(Character character);
    void revert(Character character);
    String getName();
}
